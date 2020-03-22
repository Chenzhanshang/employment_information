/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 11                       */
/* Created on:     2020/3/8 19:34:21                            */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_T_ANNOUN_REFERENCE_T_USER') then
    alter table t_announcement
       delete foreign key FK_T_ANNOUN_REFERENCE_T_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_CHAIR__REFERENCE_T_USER') then
    alter table t_chair_user
       delete foreign key FK_T_CHAIR__REFERENCE_T_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_CHAIR__REFERENCE_T_CHAIR') then
    alter table t_chair_user
       delete foreign key FK_T_CHAIR__REFERENCE_T_CHAIR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_FEEDBA_REFERENCE_T_USER') then
    alter table t_feedback
       delete foreign key FK_T_FEEDBA_REFERENCE_T_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_JOB_US_REFERENCE_T_USER') then
    alter table t_job_user
       delete foreign key FK_T_JOB_US_REFERENCE_T_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_JOB_US_REFERENCE_T_JOB') then
    alter table t_job_user
       delete foreign key FK_T_JOB_US_REFERENCE_T_JOB
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_announcement'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_announcement
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_chair'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_chair
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_chair_user'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_chair_user
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_feedback'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_feedback
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_file'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_file
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_job'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_job
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_job_user'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_job_user
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_user'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_user
end if;

/*==============================================================*/
/* Table: t_announcement                                        */
/*==============================================================*/
create table t_announcement 
(
   announcement_id      varchar(48)                    not null,
   user_id              varchar(48)                    null,
   announcement_content varchar(255)                   null,
   announcement_title   varchar(48)                    null,
   constraint PK_T_ANNOUNCEMENT primary key clustered (announcement_id)
);

comment on table t_announcement is 
'公告表';

/*==============================================================*/
/* Table: t_chair                                               */
/*==============================================================*/
create table t_chair 
(
   chair_id             varchar(48)                    not null,
   chair_time           varchar(32)                    null,
   chair_site           varchar(40)                    null,
   chair_sum            int                            null,
   now_sum              int                            null,
   chair_name           varchar(48)                    null,
   constraint PK_T_CHAIR primary key clustered (chair_id)
);

comment on table t_chair is 
'讲座表';

/*==============================================================*/
/* Table: t_chair_user                                          */
/*==============================================================*/
create table t_chair_user 
(
   user_id              varchar(48)                    not null,
   chair_id             varchar(48)                    not null,
   constraint PK_T_CHAIR_USER primary key clustered (user_id, chair_id)
);

comment on table t_chair_user is 
'讲座学生中间表';

/*==============================================================*/
/* Table: t_feedback                                            */
/*==============================================================*/
create table t_feedback 
(
   feedback_id          varchar(48)                    not null,
   user_id              varchar(48)                    null,
   feedback_content     varchar(20)                    null,
   constraint PK_T_FEEDBACK primary key clustered (feedback_id)
);

comment on table t_feedback is 
'反馈表';

/*==============================================================*/
/* Table: t_file                                                */
/*==============================================================*/
create table t_file 
(
   file_id              varchar(48)                    not null,
   file_name            varchar(64)                    null,
   file_path            varchar(128)                   null,
   file_describe        varchar(48)                    null,
   constraint PK_T_FILE primary key clustered (file_id)
);

comment on table t_file is 
'文件表';

/*==============================================================*/
/* Table: t_job                                                 */
/*==============================================================*/
create table t_job 
(
   job_id               varchar(48)                    not null,
   job_time             varchar(32)                    null,
   job_site             varchar(40)                    null,
   job_sum              int                            null,
   now_sum              int                            null,
   job_name             varchar(48)                    null,
   constraint PK_T_JOB primary key clustered (job_id)
);

comment on table t_job is 
'招聘会表';

/*==============================================================*/
/* Table: t_job_user                                            */
/*==============================================================*/
create table t_job_user 
(
   user_id              varchar(48)                    not null,
   job_id               varchar(48)                    not null,
   constraint PK_T_JOB_USER primary key clustered (user_id, job_id)
);

comment on table t_job_user is 
'招聘会学生中间表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user 
(
   user_id              varchar(48)                    not null,
   name                 varchar(20)                    null,
   phone                varchar(20)                    null,
   email                varchar(32)                    null,
   user_name            varchar(32)                    null,
   id_card              varchar(18)                    null,
   password             varchar(20)                    null,
   role                 int                            null,
   sex                  varchar(10)                    null,
   constraint PK_T_USER primary key clustered (user_id)
);

comment on table t_user is 
'用户表';

alter table t_announcement
   add constraint FK_T_ANNOUN_REFERENCE_T_USER foreign key (user_id)
      references t_user (user_id)
      on update restrict
      on delete restrict;

alter table t_chair_user
   add constraint FK_T_CHAIR__REFERENCE_T_USER foreign key (user_id)
      references t_user (user_id)
      on update restrict
      on delete restrict;

alter table t_chair_user
   add constraint FK_T_CHAIR__REFERENCE_T_CHAIR foreign key (chair_id)
      references t_chair (chair_id)
      on update restrict
      on delete restrict;

alter table t_feedback
   add constraint FK_T_FEEDBA_REFERENCE_T_USER foreign key (user_id)
      references t_user (user_id)
      on update restrict
      on delete restrict;

alter table t_job_user
   add constraint FK_T_JOB_US_REFERENCE_T_USER foreign key (user_id)
      references t_user (user_id)
      on update restrict
      on delete restrict;

alter table t_job_user
   add constraint FK_T_JOB_US_REFERENCE_T_JOB foreign key (job_id)
      references t_job (job_id)
      on update restrict
      on delete restrict;

