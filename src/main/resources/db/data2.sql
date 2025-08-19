insert into account(id, name, username, password, account_number) values (
'12346', 'Ibrahim Babs', 'Bramtech', 'bram12345', '1123456789');


insert into transaction(id, amount, account_number, transaction_type)
values('120', 20_000, '1123456789', '0'),
      ('121', 10_000, '1123456789', 1),
      ('122', 12_000, '1123456789', 1),
      ('123', 11_000, '1123456789', 0),
      ('124', 9_000, '1123456789', 0),
      ('125', 92_000, '0123456787', 1),
      ('126', 1_800, '9012345671', 0);