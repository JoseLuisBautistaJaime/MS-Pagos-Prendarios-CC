-- --------------------------------------------------------------------------------------------------------------------- --
-- ----------------- SE AGREGA POSIBLE SUB-ESTATUS: EDO CTA COMPL -> CONCILIACION -> EDO CTA COMPL --------------------- --
-- ---------------------------------------- [2020-02-17 19:24:59] ------------------------------------------------------ --
-- --------------------------------------------------------------------------------------------------------------------- --
INSERT INTO tk_maquina_estados_subestatus_conciliacion(id, nombre_proceso, id_sub_estatus_inicial, id_sub_estatus_posible)
	VALUES( 29, 'CONCILIACION_MERGE', 8, 13);