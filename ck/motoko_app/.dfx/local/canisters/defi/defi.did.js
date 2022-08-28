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
  const Result = IDL.Variant({ 'ok' : IDL.Text, 'err' : IDL.Text });
  const Room = IDL.Record({
    '_wifi' : IDL.Bool,
    '_roomID' : IDL.Nat,
    '_bed' : IDL.Text,
    'booked' : IDL.Bool,
    '_sellPrice' : IDL.Nat,
    'holder' : IDL.Principal,
    '_benefits' : IDL.Vec(IDL.Text),
    '_name' : IDL.Text,
    '_size' : IDL.Text,
  });
  const Hotel = IDL.Record({
    '_rating' : IDL.Nat,
    '_priceRange' : IDL.Nat,
    '_hotelID' : IDL.Principal,
    '_information' : IDL.Text,
    '_name' : IDL.Text,
  });
  const Review = IDL.Record({
    '_rating' : IDL.Nat,
    '_reviewText' : IDL.Text,
    '_num' : IDL.Nat,
    '_score' : IDL.Int,
    'reviewer' : IDL.Principal,
  });
  const Token = IDL.Principal;
  const Defi = IDL.Service({
    'addReview' : IDL.Func([IDL.Principal, IDL.Nat, IDL.Text], [TxReceipt], []),
    'addRoom' : IDL.Func(
        [
          IDL.Nat,
          IDL.Text,
          IDL.Nat,
          IDL.Text,
          IDL.Text,
          IDL.Vec(IDL.Text),
          IDL.Bool,
        ],
        [Result],
        [],
      ),
    'book' : IDL.Func([IDL.Nat, IDL.Int, IDL.Int], [TxReceipt], []),
    'cancelBooking' : IDL.Func([IDL.Nat], [TxReceipt], []),
    'connect' : IDL.Func([], [TxReceipt], []),
    'getBookedRooms' : IDL.Func([], [IDL.Vec(Room)], []),
    'getHotelInformation' : IDL.Func([], [Hotel], []),
    'getInvariant' : IDL.Func([], [IDL.Nat], ['query']),
    'getMyBookedRooms' : IDL.Func([], [IDL.Vec(Room)], []),
    'getReviews' : IDL.Func([IDL.Principal], [IDL.Vec(Review)], []),
    'getRoom' : IDL.Func([IDL.Nat], [IDL.Opt(Room)], []),
    'getRoomsLength' : IDL.Func([], [IDL.Nat], []),
    'getUnBookedRooms' : IDL.Func([], [IDL.Vec(Room)], []),
    'hasBooked' : IDL.Func([IDL.Principal], [IDL.Bool], []),
    'init' : IDL.Func([], [], []),
    'isHotelPrincipal' : IDL.Func([], [IDL.Bool], []),
    'payGenerateTrip' : IDL.Func([], [TxReceipt], []),
    'removeBooking' : IDL.Func([IDL.Nat, IDL.Bool], [Result], []),
    'rewardReview' : IDL.Func([], [], []),
    'scoreReview' : IDL.Func(
        [IDL.Principal, IDL.Principal, IDL.Int],
        [IDL.Int],
        [],
      ),
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
