insert into account(id, name, username, password, account_number, balance)
values (
'12345', 'Ibrahim', 'Bram', 'bram123', '0123456789', 10_000);


insert into transaction(id, amount, account_number, transaction_type)
values('100', 20_000, '0123456789', '0'),
       ('101', 10_000, '0123456789', 1),
       ('102', 12_000, '0123456789', 1),
       ('103', 11_000, '0123456789', 0),
       ('104', 9_000, '0123456789', 0),
       ('105', 92_000, '0123456787', 1),
       ('106', 1_800, '9012345671', 0);