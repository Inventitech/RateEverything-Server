# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table rating (
  rating                    integer,
  recorded                  timestamp)
;

create table user (
  id                        varchar(255),
  access_token              varchar(255),
  registered                timestamp)
;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists rating;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

