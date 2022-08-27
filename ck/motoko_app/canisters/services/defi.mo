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
}