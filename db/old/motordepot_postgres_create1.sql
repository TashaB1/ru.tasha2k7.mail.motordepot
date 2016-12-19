set search_path to motordepot;

CREATE TABLE "application" (
	"id" serial NOT NULL,
	"number_application" bigint NOT NULL UNIQUE,
	"date_application" TIMESTAMP NOT NULL,
	"client_id" bigint NOT NULL,
	"trip_id" bigint NOT NULL,
	"weight_cargo_kg" real NOT NULL,
	"length_cargo_m" real NOT NULL,
	"width_cargo_m" real NOT NULL,
	"heigth_cargo_m" real NOT NULL,
	"beginning_trip_mark" DATE,
	"delivery_cargo_mark" DATE,
	"ending_trip_mark" DATE,
	"dispatcher_id" bigint,
	"driver_id" bigint,
	"note" character varying(512),
	"status" character varying(256) NOT NULL,
	CONSTRAINT application_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "trip" (
	"id" serial NOT NULL,
	"point_departure" character varying(256) NOT NULL,
	"destination" character varying(256) NOT NULL,
	"mileage_km" real NOT NULL,
	CONSTRAINT trip_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "employee" (
	"id" serial NOT NULL,
	"firstname" character varying(512) NOT NULL,
	"lastname" character varying(512) NOT NULL,
	"surname" character varying(512),
	"birthday" DATE,
	"number_driver_license" character varying(128),
	"category_driver_license" character varying(128),
	"position" character varying(512) NOT NULL,
	"registration_data_id" bigint NOT NULL UNIQUE,
	"car_id" bigint NOT NULL UNIQUE,
	"deleted" DATE,
	CONSTRAINT employee_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "car" (
	"id" serial NOT NULL,
	"make_model" character varying(256) NOT NULL,
	"number_registration" character varying(256) NOT NULL UNIQUE,
	"capacity_carrying_kg" real NOT NULL,
	"length_dimensions_m" real NOT NULL,
	"width_dimensions_m" real NOT NULL,
	"heigth_dimensions_m" real NOT NULL,
	"condition_vehical" BOOLEAN NOT NULL,
	"inspection_date" DATE NOT NULL,
	"deleted" DATE,
	CONSTRAINT car_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "client" (
	"id" serial NOT NULL,
	"name_client" character varying(512) NOT NULL UNIQUE,
	"address" character varying(512) NOT NULL,
	"number_phone" character varying(256) NOT NULL,
	"registration_data_id" bigint NOT NULL UNIQUE,
	"deleted" DATE,
	CONSTRAINT client_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "role" (
	"id" serial NOT NULL,
	"name_role" character varying(128) NOT NULL UNIQUE,
	CONSTRAINT role_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "registration_2_role" (
	"registration_id" bigint NOT NULL,
	"role_id" bigint NOT NULL,
	UNIQUE(registration_id, role_id)
) WITH (
  OIDS=FALSE
);



CREATE TABLE "registration_data" (
	"id" serial NOT NULL,
	"email" character varying(128) NOT NULL UNIQUE,
	"password" character varying(256) NOT NULL,
	CONSTRAINT registration_data_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "application" ADD CONSTRAINT "application_fk0" FOREIGN KEY ("client_id") REFERENCES "client"("id");
ALTER TABLE "application" ADD CONSTRAINT "application_fk1" FOREIGN KEY ("trip_id") REFERENCES "trip"("id");
ALTER TABLE "application" ADD CONSTRAINT "application_fk2" FOREIGN KEY ("dispatcher_id") REFERENCES "employee"("id");
ALTER TABLE "application" ADD CONSTRAINT "application_fk3" FOREIGN KEY ("driver_id") REFERENCES "employee"("id");


ALTER TABLE "employee" ADD CONSTRAINT "employee_fk0" FOREIGN KEY ("registration_data_id") REFERENCES "registration_data"("id");
ALTER TABLE "employee" ADD CONSTRAINT "employee_fk1" FOREIGN KEY ("car_id") REFERENCES "car"("id");


ALTER TABLE "client" ADD CONSTRAINT "client_fk0" FOREIGN KEY ("registration_data_id") REFERENCES "registration_data"("id");


ALTER TABLE "registration_2_role" ADD CONSTRAINT "registration_2_role_fk0" FOREIGN KEY ("registration_id") REFERENCES "registration_data"("id");
ALTER TABLE "registration_2_role" ADD CONSTRAINT "registration_2_role_fk1" FOREIGN KEY ("role_id") REFERENCES "role"("id");


