import type { Principal } from '@dfinity/principal';
export interface Defi {
  'connect' : () => Promise<TxReceipt>,
  'payGenerateTrip' : () => Promise<TxReceipt>,
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
