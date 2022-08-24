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
import Cap "./cap/Cap";
import Root "./cap/Root";

shared(msg) actor class Services(
    _owner: Principal
) {

    private var owner_ : Principal = _owner;

    type Room {
        _roomID : Nat;
        _sellPrice : Nat;
        _size : Text;
        _bed: Text;
        _benefits : [Text];
        holder : Principal;
        _wifi : Bool;
        booked : Bool;
    };

    private var roomMap = HashMap.HashMap<Nat, Room>(1, Nat.equal, Hash.hash);
    private var rooms : [Room] = [];


    // returns tx index or error msg
    public type TxReceipt = {
        #Ok: Nat;
        #Err: {
            #InsufficientAllowance;
            #InsufficientBalance;
            #ErrorOperationStyle;
            #Unauthorized;
            #LedgerTrap;
            #ErrorTo;
            #Other: Text;
            #BlockUsed;
            #AmountTooSmall;
        };
    };
    type TokenService = actor{  transfer : (to : Principal, value : Nat) -> async TxReceipt;
                                transferFrom : (from : Principal, to : Principal, value : Nat) -> async TxReceipt;
                                approve : (spender: Principal, value: Nat) -> async TxReceipt;
                                balanceOf : (who: Principal) -> async Nat;
                                allowance : (owner: Principal, spender: Principal) -> async Nat;
                             };
    private var token : TokenService = actor("");

    public func getRoom(room_id : Nat) : async ?Room {
        return roomMap.get(room_id);
    }

    public func getBookedRooms() : async [Room] {
        var roomList : [Room] = [];
        
        for (i in Iter.range(0, rooms.size() - 1)){
            var temp = roomMap.get(rooms[i]);
            if(temp.booked){
                roomList = Array.append<Nat>(roomList, [temp]);
            }
        }
        return roomList;
    }

    public func getUnBookedRooms() : async [Room] {
        var roomList : [Room] = [];
        
        for (i in Iter.range(0, rooms.size() - 1)){
            var temp = roomMap.get(rooms[i]);
            if(not temp.booked){
                roomList = Array.append<Nat>(roomList, [temp]);
            }
        }
        return roomList;
    }

    public shared({caller}) func book(room_id : Nat) : async Result.Result<Text,Text> {
        witch(roomMap.get(id)){
            case(null) return #err("There is no room with id : " # Nat.toText(room_id));
            case(?room) {

            }
        }
        return true;
    }

}