import type { Principal } from '@dfinity/principal';
import type { ActorMethod } from '@dfinity/agent';

export interface Defi {
  'addReview' : ActorMethod<[Principal, bigint, string], TxReceipt>,
  'addRoom' : ActorMethod<
    [bigint, string, bigint, string, string, Array<string>, boolean],
    Result,
  >,
  'book' : ActorMethod<[bigint, bigint, bigint], TxReceipt>,
  'cancelBooking' : ActorMethod<[bigint], TxReceipt>,
  'connect' : ActorMethod<[], TxReceipt>,
  'getBookedRooms' : ActorMethod<[], Array<Room>>,
  'getHotelInformation' : ActorMethod<[], Hotel>,
  'getInvariant' : ActorMethod<[], bigint>,
  'getMyBookedRooms' : ActorMethod<[], Array<Room>>,
  'getReviews' : ActorMethod<[Principal], Array<Review>>,
  'getRoom' : ActorMethod<[bigint], [] | [Room]>,
  'getRoomsLength' : ActorMethod<[], bigint>,
  'getUnBookedRooms' : ActorMethod<[], Array<Room>>,
  'hasBooked' : ActorMethod<[Principal], boolean>,
  'init' : ActorMethod<[], undefined>,
  'isHotelPrincipal' : ActorMethod<[], boolean>,
  'payGenerateTrip' : ActorMethod<[], TxReceipt>,
  'removeBooking' : ActorMethod<[bigint, boolean], Result>,
  'rewardReview' : ActorMethod<[], undefined>,
  'scoreReview' : ActorMethod<[Principal, Principal, bigint], bigint>,
  'swapYasuoToZed' : ActorMethod<[bigint], TxReceipt>,
  'swapZedToYasuo' : ActorMethod<[bigint], TxReceipt>,
  'transferFrom' : ActorMethod<
    [Principal, Principal, bigint, Token],
    TxReceipt,
  >,
  'transferZed' : ActorMethod<[Principal, bigint], TxReceipt>,
  'yasuoBalanceOf' : ActorMethod<[Principal], bigint>,
  'zedBalanceOf' : ActorMethod<[Principal], bigint>,
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
