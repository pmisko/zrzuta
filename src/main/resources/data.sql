insert into `user` (user_name, first_name, last_name)
values ('nowi', 'Jan', 'nowak');

insert into `user` (user_name, first_name, last_name)
values ('kowal', 'Jan', 'Kowal');

INSERT INTO whip_round (id, title, description, start_date, end_date, amount, user_user_name)
VALUES (nextval('whipround_seq'), 'Na auto', 'szybkie', '2020-02-15', '2020-02-27', 5000000, 'nowi' );

insert into donation (id, amount, donation_date, whip_round_id, user_user_name)
values (nextval ('donation_seq'), 100000, '2020-02-15', 1, 'kowal');

commit ;