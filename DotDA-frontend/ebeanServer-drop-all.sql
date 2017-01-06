alter table action drop constraint if exists fk_action_location_type_id;
drop index if exists ix_action_location_type_id;

alter table attribute drop constraint if exists fk_attribute_character_class_id;
drop index if exists ix_attribute_character_class_id;

alter table attribute drop constraint if exists fk_attribute_item_id;
drop index if exists ix_attribute_item_id;

alter table attribute drop constraint if exists fk_attribute_race_id;
drop index if exists ix_attribute_race_id;

alter table attributes_to_location_types drop constraint if exists fk_attributes_to_location_types_attribute;
drop index if exists ix_attributes_to_location_types_attribute;

alter table attributes_to_location_types drop constraint if exists fk_attributes_to_location_types_location_type;
drop index if exists ix_attributes_to_location_types_location_type;

alter table character drop constraint if exists fk_character_player_id;
drop index if exists ix_character_player_id;

alter table character_inventory drop constraint if exists fk_character_inventory_character;
drop index if exists ix_character_inventory_character;

alter table character_inventory drop constraint if exists fk_character_inventory_item;
drop index if exists ix_character_inventory_item;

alter table location drop constraint if exists fk_location_location_type_id;
drop index if exists ix_location_location_type_id;

drop table if exists action;

drop table if exists attribute;

drop table if exists attributes_to_location_types;

drop table if exists character;

drop table if exists character_inventory;

drop table if exists item;

drop table if exists location;

drop table if exists location_type;

drop table if exists player;

drop table if exists race;

