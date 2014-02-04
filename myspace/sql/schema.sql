create table User(
   `userId` bigint not null auto_increment,
  `userName` varchar(20),
  `pwd` varchar(20),
  `groupId` bigint,
   constraint `pk_userId` primary key(`userId`)
)charset=utf8 ENGINE=InnoDB;

create table `Group`(
   `groupId` bigint not null auto_increment,
   `grouopName` varchar(20),
    constraint `pk_groupId` primary key(`groupId`)
)charset=utf8 ENGINE=InnoDB;