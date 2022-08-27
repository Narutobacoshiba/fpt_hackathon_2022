export const idlFactory = ({ IDL }) => {
  const TxReceipt = IDL.Variant({
    'Ok' : IDL.Nat,
    'Err' : IDL.Variant({
      'InsufficientAllowance' : IDL.Null,
      'InsufficientBalance' : IDL.Null,
      'ErrorOperationStyle' : IDL.Null,
      'Unauthorized' : IDL.Null,
      'LedgerTrap' : IDL.Null,
      'ErrorTo' : IDL.Null,
      'Other' : IDL.Null,
      'BlockUsed' : IDL.Null,
      'AmountTooSmall' : IDL.Null,
    }),
  });
  const Token = IDL.Principal;
  const Defi = IDL.Service({
    'connect' : IDL.Func([], [TxReceipt], []),
    'payGenerateTrip' : IDL.Func([], [TxReceipt], []),
    'swapYasuoToZed' : IDL.Func([IDL.Nat], [TxReceipt], []),
    'swapZedToYasuo' : IDL.Func([IDL.Nat], [TxReceipt], []),
    'transferFrom' : IDL.Func(
        [IDL.Principal, IDL.Principal, IDL.Nat, Token],
        [TxReceipt],
        [],
      ),
    'transferZed' : IDL.Func([IDL.Principal, IDL.Nat], [TxReceipt], []),
    'yasuoBalanceOf' : IDL.Func([IDL.Principal], [IDL.Nat], []),
    'zedBalanceOf' : IDL.Func([IDL.Principal], [IDL.Nat], []),
  });
  return Defi;
};
export const init = ({ IDL }) => { return [IDL.Principal]; };
