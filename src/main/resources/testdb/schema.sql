drop table FILE_INFO if exists;

create table FILE_INFO (id integer identity primary key, AVERAGE_WORD_LENGTH double, FILE_NAME varchar(255), LENGTH integer, LONGEST_WORDS varchar(255), SHORTEST_WORDS varchar(255));

drop table LINE_INFO if exists;

create table LINE_INFO (ROW_NUMBER integer not NULL, AVERAGE_WORD_LENGTH double, LENGTH integer, LONGEST_WORDS varchar(255), SHORTEST_WORDS varchar(255), file_id integer);