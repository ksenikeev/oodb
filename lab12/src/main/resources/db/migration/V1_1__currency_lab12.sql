insert into dict_currency (id, ncode, code, name) values
    (1, '643','RUB','Российский рубль'),
    (2, '840','USD','Доллар США'),
    (3, '978', 'EUR','Евро');

insert into exchangerate (id, currency1_id, currency2_id, price, daterate) values
    ((nextval('exchange_rate_seq')),2,1,75.1107,'2021-02-07'),
    ((nextval('exchange_rate_seq')),3,1,89.8850,'2021-02-07'),
    ((nextval('exchange_rate_seq')),2,1,75.1107,'2021-02-08'),
    ((nextval('exchange_rate_seq')),3,1,89.8850,'2021-02-08'),
    ((nextval('exchange_rate_seq')),2,1,74.2602,'2021-02-09'),
    ((nextval('exchange_rate_seq')),3,1,89.4019,'2021-02-09');