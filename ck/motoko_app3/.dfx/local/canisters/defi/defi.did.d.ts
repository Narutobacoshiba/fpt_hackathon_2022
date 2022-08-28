import type { Principal } from '@dfinity/principal';
export interface Defi {
  'addReview' : (arg_0: Principal, arg_1: bigint, arg_2: string) => Promise<
      TxReceipt
    >,
  'addRoom' : (
      arg_0: bigint,
      arg_1: string,
      arg_2: bigint,
      arg_3: string,
      arg_4: string,
      arg_5: Array<string>,
      arg_6: boolean,
    ) => Promise<Result>,
  'book' : (arg_0: bigint, arg_1: bigint, arg_2: bigint) => Promise<TxReceipt>,
  'cancelBooking' : (arg_0: bigint) => Promise<TxReceipt>,
  'connect' : () => Promise<TxReceipt>,
  'getBookedRooms' : () => Promise<Array<Room>>,
  'getHotelInformation' : () => Promise<Hotel>,
  'getInvariant' : () => Promise<bigint>,
  'getMyBookedRooms' : () => Promise<Array<Room>>,
  'getReviews' : (arg_0: Principal) => Promise<Array<Review>>,
  'getRoom' : (arg_0: bigint) => Promise<[] | [Room]>,
  'getRoomsLength' : () => Promise<bigint>,
  'getUnBookedRooms' : () => Promise<Array<Room>>,
  'hasBooked' : (arg_0: Principal) => Promise<boolean>,
  'init' : () => Promise<undefined>,
  'isHotelPrincipal' : () => Promise<boolean>,
  'payGenerateTrip' : () => Promise<TxReceipt>,
  'removeBooking' : (arg_0: bigint, arg_1: boolean) => Promise<Result>,
  'scoreReview' : (
      arg_0: Principal,
      arg_1: Principal,
      arg_2: bigint,
    ) => Promise<bigint>,
  'swapYasuoToZed' : (arg_0: bigint) => Promise<TxReceipt>,
  'swapZedToYasuo' : (arg_0: bigint) => Promise<TxReceipt>,
  'transferFrom' : (
      arg_0: Principal,
      arg_1: Principal,
      arg_2: bigint,
      arg_3: Token,
    ) => Promise<TxReceipt>,
  'transferZed' : (arg_0: Principal, arg_1: bigint) => Promise<TxReceipt>,
  'yasuoBalanceOf' : (arg_0: Principal) => Promise<bigint>,
  'zedBalanceOf' : (arg_0: Principal) => Promise<bigint>,
}
export interface Hotel {
  '_rating' : bigint,
  '_priceRange' : bigint,
  '_hotelID' : Principal,
  '_information' : string,
  '_name' : string,
}
export type Result = { 'ok' : string } |
  { 'err' : string };
export interface Review {
  '_rating' : bigint,
  '_reviewText' : string,
  '_num' : bigint,
  '_score' : bigint,
  'reviewer' : Principal,
}
export interface Room {
  '_wifi' : boolean,
  '_roomID' : bigint,
  '_bed' : string,
  'booked' : boolean,
  '_sellPrice' : bigint,
  'holder' : Principal,
  '_benefits' : Array<string>,
  '_name' : string,
  '_size' : string,
}
export type Token = Principal;
export type TxReceipt = { 'Ok' : bigint } |
  {
    'Err' : { 'InsufficientAllowance' : null } |
      { 'InsufficientBalance' : null } |
      { 'ErrorOperationStyle' : null } |
      { 'Unauthorized' : null } |
      { 'LedgerTrap' : null } |
      { 'ErrorTo' : null } |
      { 'Other' : null } |
      { 'BlockUsed' : null } |
      { 'AmountTooSmall' : null }
  };
export interface _SERVICE extends Defi {}
