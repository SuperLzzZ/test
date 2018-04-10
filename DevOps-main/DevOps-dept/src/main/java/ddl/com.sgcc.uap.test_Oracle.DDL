
    drop table DEPARTMENT cascade constraints;

    create table DEPARTMENT (
        ID varchar2(42 char) not null,
        DEPNAME varchar2(20 char),
        DEPPARENTID varchar2(42 char),
        DEPDESC varchar2(20 char),
        primary key (ID)
    );

    comment on table DEPARTMENT is
        'Department';

    comment on column DEPARTMENT.ID is
        'id';

    comment on column DEPARTMENT.DEPNAME is
        '部门名称';

    comment on column DEPARTMENT.DEPPARENTID is
        '父ID';

    comment on column DEPARTMENT.DEPDESC is
        '描述';
