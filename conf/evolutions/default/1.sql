# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table rating (
  rating                    integer,
  recorded                  timestamp)
;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists rating;

SET REFERENTIAL_INTEGRITY TRUE;

