import HashMap "mo:base/HashMap";
import Principal "mo:base/Principal";
import Types "./types";
import Time "mo:base/Time";
import Iter "mo:base/Iter";
import Array "mo:base/Array";
import Option "mo:base/Option";
import Order "mo:base/Order";
import Nat "mo:base/Nat";
import Nat64 "mo:base/Nat64";
import Result "mo:base/Result";
import Text "mo:base/Text";
import ExperimentalCycles "mo:base/ExperimentalCycles";
import T "./types"

shared(msg) actor class Defi(
    _owner: Principal,
) {
    private var owner_ : Principal = _owner;
    private var yasuo : Principal = Principal.fromText("r7inp-6aaaa-aaaaa-aaabq-cai");
    private var zed : Principal = Principal.fromText("rkp4c-7iaaa-aaaaa-aaaca-cai");
    private var this : Principal = Principal.fromText("ryjl3-tyaaa-aaaaa-aaaba-cai");

    // token
    private var users = HashMap.HashMap<Principal, Bool>(1, Principal.equal, Principal.hash);
    private var free_token : Nat = 100;

    public shared({caller}) func connect(): async T.TxReceipt{
        switch(users.get(caller)){
            case(null){
                users.put(caller, true);
                let dip20_yasuo = actor (Principal.toText(yasuo)) : T.DIPInterface;
                let res_yasuo = await dip20_yasuo.approveToOwner(caller, 100000000);
                let dip20_zed = actor (Principal.toText(zed)) : T.DIPInterface;
                let res_zed = await dip20_zed.approveToOwner(caller, 100000000);
                return await dip20_zed.transfer(caller, free_token);
            };
            case(?user) return #Ok(0);
        }
    };

    public func zedBalanceOf(caller: Principal): async Nat {
        let dip20 = actor (Principal.toText(zed)) : T.DIPInterface;
        return await dip20.balanceOf(caller);
    };

    public func yasuoBalanceOf(caller: Principal): async Nat{
        let dip20 = actor (Principal.toText(yasuo)) : T.DIPInterface;
        return await dip20.balanceOf(caller);
    };

    public shared({caller}) func payGenerateTrip(): async T.TxReceipt {
        let fee : Nat = 10;
        let dip20 = actor (Principal.toText(zed)) : T.DIPInterface;
        return await dip20.transferFrom(caller, this, fee);
    };

    public func transferFrom(from: Principal, to: Principal, value: Nat, token: T.Token): async T.TxReceipt {
        if(token == yasuo){
            let dip20 = actor (Principal.toText(token)) : T.DIPInterface;
            return await dip20.transferFrom(from, to, value);
        };
        return #Err(#Other);
    };

    public shared({caller}) func swapZedToYasuo(value: Nat) : async T.TxReceipt{
        let dip20_zed = actor (Principal.toText(zed)) : T.DIPInterface;
        let zed_balance = await dip20_zed.balanceOf(caller);
        if(zed_balance >= value){
            let update_zed = await dip20_zed.transferFrom(caller, this, value);

            let dip20_yasuo = actor (Principal.toText(yasuo)) : T.DIPInterface;
            let update_yasuo = dip20_yasuo.transfer(caller, value / 10);
            return #Ok(value / 10);
        };
        return #Err(#Other);
    };

    public shared({caller}) func swapYasuoToZed(value: Nat) : async T.TxReceipt{
        let dip20_yasuo = actor (Principal.toText(yasuo)) : T.DIPInterface;
        let yasuo_balance = await dip20_yasuo.balanceOf(caller);
        if(yasuo_balance >= value){
            let update_yasuo = await dip20_yasuo.transferFrom(caller, this, value);

            let dip20_zed = actor (Principal.toText(zed)) : T.DIPInterface;
            let update_zed = dip20_zed.transfer(caller, value * 10);
            return #Ok(value * 10);
        };
        return #Err(#Other);
    };


    public shared({caller}) func transferZed(reciver: Principal, value: Nat) : async T.TxReceipt{
        let dip20_zed = actor (Principal.toText(zed)) : T.DIPInterface;
        let zed_balance = await dip20_zed.balanceOf(caller);
        if(zed_balance >= value){
            let update_zed = await dip20_zed.transferFrom(caller, reciver, value);
            return #Ok(value);
        };
        return #Err(#Other);
    };

    // booking
    // type Room {
    //     _roomID : Nat;
    //     _sellPrice : Nat;
    //     _size : Text;
    //     _bed: Text;
    //     _benefits : [Text];
    //     holder : Principal;
    //     _wifi : Bool;
    //     booked : Bool;
    // };

    // private var roomMap = HashMap.HashMap<Nat, Room>(1, Nat.equal, Hash.hash);
    // private var rooms : [Room] = [];

    // private var book_fee : Nat = 1;

    // public func getRoom(room_id : Nat) : async ?Room {
    //     return roomMap.get(room_id);
    // };

    // public func getRoomsLength() : async Nat {
    //     return rooms.size();
    // };

    // public func getBookedRooms() : async [Room] {
    //     var roomList : [Room] = [];
        
    //     for (i in Iter.range(0, rooms.size() - 1)){
    //         var temp = roomMap.get(rooms[i]);
    //         if(temp.booked){
    //             roomList = Array.append<Nat>(roomList, [temp]);
    //         }
    //     }
    //     return roomList;
    // };

    // public func getUnBookedRooms() : async [Room] {
    //     var roomList : [Room] = [];
        
    //     for (i in Iter.range(0, rooms.size() - 1)){
    //         var temp = roomMap.get(rooms[i]);
    //         if(not temp.booked){
    //             roomList = Array.append<Nat>(roomList, [temp]);
    //         }
    //     }
    //     return roomList;
    // };

    // public shared({caller}) func book(room_id : Nat) : async Result.Result<Text,Text> {
    //     let dip20_yasuo = actor (Principal.toText(yasuo)) : T.DIPInterface;
    //     let yasuo_balance = await dip20_yasuo.balanceOf(caller);
    //     if(yasuo_balance >= book_fee){
    //         switch(roomMap.get(id)){
    //             case(null) return #err("There is no room with id : " # Nat.toText(room_id));
    //             case(?room) {
    //                 if(not room.booked){
    //                     roomMap.put(room_id,{
    //                         _roomID = room.room_id;
    //                         _sellPrice = room._sellPrice;
    //                         _size = room._size;
    //                         _bed = room._bed;
    //                         _benefits = room._benefits;
    //                         holder = caller;
    //                         _wifi = room._wifi;
    //                         booked = true;
    //                     })
    //                     await token.transferFrom(caller, this, book_fee);
    //                 }else{
    //                     return #err("This room is booked");
    //                 }
    //             }
    //         }
    //         return #ok();
    //     }
    //     return #err("")
    // };

    // public shared({caller}) func removeBooking(room_id : Nat) : async Result.Result<Text,Text> {
    //     switch(roomMap.get(id)){
    //         case(null) return #err("There is no room with id : " # Nat.toText(room_id));
    //         case(?room) {
    //             if(Principal.equal(caller, owner_)){
    //                 roomMap.put(room_id,{
    //                     _roomID = room.room_id;
    //                     _sellPrice = room._sellPrice;
    //                     _size = room._size;
    //                     _bed = room._bed;
    //                     _benefits = room._benefits;
    //                     holder = owner_;
    //                     _wifi = room._wifi;
    //                     booked = false;
    //                 })
    //             }else{
    //                 return #err("You cannot remove this booking");
    //             }
    //         }
    //     }
    //     return #ok();
    // };

    // public shared({caller}) func cancelBooking(room_id : Nat) : async Result.Result<Text,Text> {
    //     switch(roomMap.get(id)){
    //         case(null) return #err("There is no room with id : " # Nat.toText(room_id));
    //         case(?room) {
    //             holder : Principal = room.holder;
    //             if(Principal.equal(caller, holder)){
    //                 roomMap.put(room_id,{
    //                     _roomID = room.room_id;
    //                     _sellPrice = room._sellPrice;
    //                     _size = room._size;
    //                     _bed = room._bed;
    //                     _benefits = room._benefits;
    //                     holder = owner_;
    //                     _wifi = room._wifi;
    //                     booked = false;
    //                 })
    //                 await token.transferFrom(this, caller, book_fee);
    //             }else{
    //                 return #err("You cannot remove this booking");
    //             }
    //         }
    //     }
    //     return #ok();
    // };


    // public shared({caller}) func addRoom(room_id : Nat, sell_price : Nat, size : Text,
    //                                      bed : Text, benefits : [Text], wifi : Bool) : async Result.Result<Text,Text> {
    //     switch(roomMap.get(id)){
    //         case(null) {
    //             roomMap.put(room_id, {
    //                 _roomID = room_id;
    //                 _sellPrice = sell_price;
    //                 _size = size;
    //                 _bed = bed;
    //                 _benefits = benefits;
    //                 holder = owner_;
    //                 _wifi = wifi;
    //                 booked = false;
    //             });
    //         }
    //         case(?room) return #err("Room with id : " # Nat.toText(room_id) # " already exists");
    //     }
    //     return #ok();
    // };
}