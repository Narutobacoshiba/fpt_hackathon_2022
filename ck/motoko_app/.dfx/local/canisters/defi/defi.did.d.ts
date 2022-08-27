import type { Principal } from '@dfinity/principal';
import type { ActorMethod } from '@dfinity/agent';

export interface Defi {
  'connect' : ActorMethod<[], TxReceipt>,
  'payGenerateTrip' : ActorMethod<[], TxReceipt>,
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
