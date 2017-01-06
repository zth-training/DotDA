create table action (
  id                            varchar(255) not null,
  type                          varchar(6),
  location_type_id              varchar(255),
  constraint ck_action_type check ( type in ('Trade','Search','Attack')),
  constraint pk_action primary key (id)
);

create table attribute (
  discriminator                 varchar(31) not null,
  id                            varchar(255) not null,
  type                          varchar(14),
  value                         integer,
  character_class_id            varchar(255),
  item_id                       varchar(255),
  race_id                       varchar(255),
  constraint ck_attribute_type check ( type in ('Agility','Intelligence','Wisdom','Speed','Mana','CriticalRating','Strength','Health','Stamina')),
  constraint pk_attribute primary key (id)
);

create table attributes_to_location_types (
  attribute_id                  varchar(255) not null,
  location_type_id              varchar(255) not null,
  constraint pk_attributes_to_location_types primary key (attribute_id,location_type_id)
);

create table character (
  discriminator                 varchar(31) not null,
  id                            varchar(255) not null,
  name                          varchar(255),
  player_id                     varchar(255),
  constraint pk_character primary key (id)
);

create table character_inventory (
  character_id                  varchar(255) not null,
  item_id                       varchar(255) not null,
  constraint pk_character_inventory primary key (character_id,item_id)
);

create table item (
  id                            varchar(255) not null,
  name                          varchar(255),
  slot                          varchar(9),
  value                         integer,
  equipped                      boolean,
  constraint ck_item_slot check ( slot in ('Head','RightHand','LeftArm','LeftLeg','RightLeg','Torso','Neck','RightArm','LeftRing','Backpack','LeftHand','RightRing')),
  constraint pk_item primary key (id)
);

create table location (
  id                            varchar(255) not null,
  name                          varchar(255),
  location_type_id              varchar(255),
  constraint pk_location primary key (id)
);

create table location_type (
  id                            varchar(255) not null,
  name                          varchar(255),
  constraint pk_location_type primary key (id)
);

create table player (
  id                            varchar(255) not null,
  username                      varchar(255),
  password_hash                 varchar(255),
  constraint pk_player primary key (id)
);

create table race (
  id                            varchar(255) not null,
  name                          varchar(255),
  playable                      boolean,
  constraint pk_race primary key (id)
);

alter table action add constraint fk_action_location_type_id foreign key (location_type_id) references location_type (id) on delete restrict on update restrict;
create index ix_action_location_type_id on action (location_type_id);

alter table attribute add constraint fk_attribute_character_class_id foreign key (character_class_id) references character (id) on delete restrict on update restrict;
create index ix_attribute_character_class_id on attribute (character_class_id);

alter table attribute add constraint fk_attribute_item_id foreign key (item_id) references item (id) on delete restrict on update restrict;
create index ix_attribute_item_id on attribute (item_id);

alter table attribute add constraint fk_attribute_race_id foreign key (race_id) references race (id) on delete restrict on update restrict;
create index ix_attribute_race_id on attribute (race_id);

alter table attributes_to_location_types add constraint fk_attributes_to_location_types_attribute foreign key (attribute_id) references attribute (id) on delete restrict on update restrict;
create index ix_attributes_to_location_types_attribute on attributes_to_location_types (attribute_id);

alter table attributes_to_location_types add constraint fk_attributes_to_location_types_location_type foreign key (location_type_id) references location_type (id) on delete restrict on update restrict;
create index ix_attributes_to_location_types_location_type on attributes_to_location_types (location_type_id);

alter table character add constraint fk_character_player_id foreign key (player_id) references player (id) on delete restrict on update restrict;
create index ix_character_player_id on character (player_id);

alter table character_inventory add constraint fk_character_inventory_character foreign key (character_id) references character (id) on delete restrict on update restrict;
create index ix_character_inventory_character on character_inventory (character_id);

alter table character_inventory add constraint fk_character_inventory_item foreign key (item_id) references item (id) on delete restrict on update restrict;
create index ix_character_inventory_item on character_inventory (item_id);

alter table location add constraint fk_location_location_type_id foreign key (location_type_id) references location_type (id) on delete restrict on update restrict;
create index ix_location_location_type_id on location (location_type_id);

