create or replace function vcf_topo_schema()
RETURNS void AS
$BODY$
BEGIN

if (SELECT count(1) FROM   pg_class c JOIN pg_namespace n ON n.oid = c.relnamespace WHERE  c.relname = 'message') = 0 THEN
CREATE TABLE message
(
  id serial primary key,
  key varchar,
  value varchar
);
end if;

END
$BODY$
LANGUAGE 'plpgsql' VOLATILE;

select vcf_topo_schema();