import type { Principal } from '@dfinity/principal';
export type Errors = { 'Unauthorized' : null } |
  { 'TokenNotExist' : null } |
  { 'InvalidOperator' : null };
export type MintResult = { 'Ok' : [bigint, bigint] } |
  { 'Err' : Errors };
export interface NFTSale {
  'approve' : (arg_0: bigint, arg_1: Principal) => Promise<TxReceipt>,
  'balanceOf' : (arg_0: Principal) => Promise<bigint>,
  'batchMint' : (
      arg_0: Principal,
      arg_1: Array<[] | [TokenMetadata]>,
    ) => Promise<MintResult>,
  'batchSetTokenMetadata' : (arg_0: Array<[bigint, TokenMetadata]>) => Promise<
      TxReceipt
    >,
  'batchTransferFrom' : (
      arg_0: Principal,
      arg_1: Principal,
      arg_2: Array<bigint>,
    ) => Promise<TxReceipt>,
  'burn' : (arg_0: bigint) => Promise<TxReceipt>,
  'create_profile' : (arg_0: Profile) => Promise<Profile>,
  'delete_profile' : (arg_0: bigint) => Promise<Result_1>,
  'getAllTokens' : () => Promise<Array<TokenInfoExt>>,
  'getOperator' : (arg_0: bigint) => Promise<Principal>,
  'getTokenInfo' : (arg_0: bigint) => Promise<TokenInfoExt>,
  'getTransaction' : (arg_0: bigint) => Promise<TxRecord>,
  'getTransactions' : (arg_0: bigint, arg_1: bigint) => Promise<
      Array<TxRecord>
    >,
  'getUserInfo' : (arg_0: Principal) => Promise<UserInfoExt>,
  'getUserTokens' : (arg_0: Principal) => Promise<Array<TokenInfoExt>>,
  'getUserTransactionAmount' : (arg_0: Principal) => Promise<bigint>,
  'getUserTransactions' : (
      arg_0: Principal,
      arg_1: bigint,
      arg_2: bigint,
    ) => Promise<Array<TxRecord>>,
  'get_all_profile' : () => Promise<Array<[bigint, Profile]>>,
  'historySize' : () => Promise<bigint>,
  'isApprovedForAll' : (arg_0: Principal, arg_1: Principal) => Promise<boolean>,
  'mint' : (arg_0: Principal, arg_1: [] | [TokenMetadata]) => Promise<
      MintResult
    >,
  'ownerOf' : (arg_0: bigint) => Promise<Principal>,
  'read_profile' : (arg_0: bigint) => Promise<[] | [Profile]>,
  'setApprovalForAll' : (arg_0: Principal, arg_1: boolean) => Promise<
      TxReceipt
    >,
  'setOwner' : (arg_0: Principal) => Promise<Principal>,
  'setTokenMetadata' : (arg_0: bigint, arg_1: TokenMetadata) => Promise<
      TxReceipt
    >,
  'totalSupply' : () => Promise<bigint>,
  'transfer' : (arg_0: Principal, arg_1: bigint) => Promise<TxReceipt>,
  'transferFrom' : (
      arg_0: Principal,
      arg_1: Principal,
      arg_2: bigint,
    ) => Promise<TxReceipt>,
  'update_profile' : (arg_0: bigint, arg_1: Profile) => Promise<Result>,
}
export type Operation = { 'transferFrom' : null } |
  { 'burn' : null } |
  { 'approveAll' : null } |
  { 'mint' : [] | [TokenMetadata__1] } |
  { 'approve' : null } |
  { 'createOrder' : null } |
  { 'setMetadata' : null } |
  { 'transfer' : null } |
  { 'revokeAll' : null };
export interface Profile {
  'id' : bigint,
  'sex' : string,
  'name' : string,
  'address' : string,
  'date_of_birth' : string,
  'phone' : string,
}
export type Record = { 'metadata' : [] | [TokenMetadata__1] } |
  { 'user' : Principal };
export type Result = { 'ok' : string } |
  { 'err' : string };
export type Result_1 = { 'ok' : null } |
  { 'err' : string };
export type Time = bigint;
export interface TokenInfoExt {
  'owner' : Principal,
  'metadata' : [] | [TokenMetadata__1],
  'operator' : [] | [Principal],
  'timestamp' : Time,
  'index' : bigint,
}
export interface TokenMetadata { 'tokenUri' : string }
export interface TokenMetadata__1 { 'tokenUri' : string }
export type TxReceipt = { 'Ok' : bigint } |
  { 'Err' : Errors };
export interface TxRecord {
  'op' : Operation,
  'to' : Record,
  'tokenIndex' : [] | [bigint],
  'from' : Record,
  'timestamp' : Time,
  'caller' : Principal,
  'index' : bigint,
}
export interface UserInfoExt {
  'allowedTokens' : Array<bigint>,
  'tokens' : Array<bigint>,
  'operators' : Array<Principal>,
  'allowedBy' : Array<Principal>,
}
export interface _SERVICE extends NFTSale {}
