-- ------------------------------------------------------------------------------------------------------------
-- FASE 1 PAGOS ------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------
INSERT INTO tk_catalogo(id, descripcion_corta, descripcion, nombre_tabla, activo) VALUES
(3, 'Afiliacion', 'Catalogo de afiliaciones', 'tc_afiliacion', 1),
(4, 'EstatusPago', 'Estatus de las transacciones o pagos', 'tk_estatus_transaccion', 1),
(5, 'ReglaNegocio', 'Reglas de negocio', 'tk_regla_negocio', 1),
(6, 'Variable', 'Variables para la aplicacion', 'tk_variable', 1),
(7, 'Categoria', 'Categorias de los codigos de estado de cuenta', 'tk_categoria', 1);

-- INSERT DEFAULT VALUE IN STATUS TRANSACTION CATALOG
INSERT INTO tk_estatus_transaccion(id, descripcion_corta, descripcion) VALUES (1,'Pregistrado','Pago Registrado');
-- INSERT INTO STATUS TRANSACTION ENDS




-- ------------------------------------------------------------------------------------------------------------
-- FASE 2 CATALOGOS -------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------

-- INSERCION INICIAL DE TIPOS DE CONTACTOS --
INSERT INTO `tk_tipo_contacto` (`id`, `estatus`, `description`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `short_description`) VALUES
(1, true, 'Contacto Midas', 'Ismael', now(), null, null, 'Contacto Midas'),
(2, true, 'Contacto Entidad', 'Ismael', now(), null, null, 'Contacto Ent');

-- INSERCION DE TIPOS DE AFILIACION --
INSERT INTO `tk_tipo_afiliacion` (`id`, `descripcion_corta`, `descripcion`) VALUES
(1, 'Ninguno', 'Ningun tipo de afiliacion'),
(2, '3DSecure', '3DSecure');

-- INSERCION DE CATEGORIAS DUMMIES --
INSERT INTO `tk_categoria` (`id`, `nombre`, `descripcion`, `estatus`, `created_date`, `last_modified_date`, `created_by`, `last_modified_by`, `descripcion_corta`) VALUES
(1, 'Ventas', 'Categoria Ventas', true, now(), null, 'Quarksoft', null, 'Cat Vtas'),
(2, 'Comisiones', 'Categoria Comisiones', true, now(), null, 'Quarksoft', null, 'Cat Com'),
(3, 'Otra', 'Otra Categoria', true, now(), null, 'Quarksoft', null, 'Otra Cat');





-- ------------------------------------------------------------------------------------------------------------
-- FASE 3 CONCILIACION ----------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------

-- ------------------------------------------------------------ --
-- INSERT PARA CATALOGO NO ADMINISTRABLE tk_estatus_transaccion --
-- ------------------ [2019-06-07 16:51:31] ------------------- --
-- ------------------------------------------------------------ --
INSERT INTO `tk_estatus_transaccion` (`id`, `descripcion_corta`, `descripcion`) VALUES
(1, 'Solicitada', 'Solicitada'),
(2, 'En Proceso', 'En Proceso'),
(3, 'Terminada', 'Terminada');

INSERT INTO `tk_estatus_devolucion` (`id`, `nombre`, `descripcion`, `estatus`, `created_date`, `created_by`, `descripcion_corta`)
VALUES ('1', 'devolucion', 'devolucion', true, '2019-05-16 16:46:23', 'NMP', 'devolucion');

-- ------------------------------------------------------------------------ --
-- INSERT PARA CATALOGO NO ADMINISTRABLE tk_estatus_movimientos_en_transito --
-- ------------------------ [2019-06-07 16:51:31] -------------------------- --
-- ------------------------------------------------------------------------- --    
INSERT INTO `tk_estatus_movimientos_en_transito` (`id`, `nombre`, `descripcion`, `estatus`, `created_date`, `last_modified_date`, `created_by`, `last_modified_by`, `descripcion_corta`) VALUES
(1, 'No identificada en MIDAS', 'No identificada en MIDAS', true, NOW(), NULL, 'Quarksoft', NULL, 'No identificada en MIDAS'),
(2, 'Solicitada', 'Solicitada', true, NOW(), NULL, 'Quarksoft', NULL, 'Solicitada');

-- --------------------------------------- --
-- ----- INSERTS INICIALES EN tk_operacion --
-- --------------------------------------- --
INSERT INTO `tk_operacion` (`id`, `tipo`, `abreviatura`, `descripcion`, `inddep`) VALUES
(8, 1, 'RF', 'Cobro Refrendo', 0),
(116, 1, 'APL', 'Abono -PagosLibres', 0),
(148, 1, 'DSO', 'Cobro Desempeño en Linea', 0);
    
-- ------------------------------------------- --
-- ----- INSERTS INICIALES EN tk_tipo_contrato --
-- ------------------------------------------- --
INSERT INTO `tk_tipo_contrato` (`id`, `descripcion`, `baja_logica`, `abreviatura`, `inddep`) VALUES
(146, 'PAGOS LIBRES', 'f', 'PL', 0),
(145, 'CLASICO', 'f', 'CL', 0);    

INSERT INTO `tk_estatus_conciliacion` (`nombre`, `descripcion`, `estatus`, `created_date`, `created_by`, `descripcion_corta`) VALUES
('Finalizada', 'Estatus actual de la conciliación', false, now(), 'Sistema', 'Estatus actual');
INSERT INTO `tk_estatus_conciliacion` (`nombre`, `descripcion`, `estatus`, `created_date`, `created_by`, `descripcion_corta`) VALUES
('En Proceso', 'Estatus actual de la conciliación', true, now(), 'Sistema', 'Estatus actual');

INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Creada', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Consulta Midas', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Consulta Midas Completada', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Consulta Midas Error', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Consulta Open Pay', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Consulta Open Pay Completada', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Consulta Open Pay Error', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Conciliacion', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Conciliacion Completada', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Conciliacion Error', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Consulta Estado de Cuenta', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Consulta Estado de Cuenta Completada', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Consulta Estado de Cuenta Error', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Enviada', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Enviada Error', true, now(), 'Sistema');
INSERT INTO `tk_sub_estatus_conciliacion` (`description`, `estatus`, `created_date`, `created_by`) VALUES ('Finalizada', true, now(), 'Sistema');





-- ------------------------------------------------------------------------------------------------------------
-- DUMMIES/ REMOVER ----------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------

INSERT INTO `to_conciliacion` (`id`, `id_estatus_conciliacion`, `id_entidad`, `id_cuenta`, `id_sub_estatus_conciliacion`, `created_date`, `created_by`, `last_modified_by`)
VALUES ('1', '2', '1', '1', '1', '2019-05-08 00:56:15', 'NMP', 'NMP');

INSERT INTO `to_global` (`id`, `id_conciliacion`, `fecha`, `movimientos`, `partidas`, `monto`, `importe_midas`, `importe_proveedor`, `importe_banco`, `devoluciones`, `diferencia_proveedor_midas`)
VALUES ('1', '1', '2019-05-11', '232', '123', '2323.0000', '32321.0000', '321213.0000', '3213.0000', '213', '213213.0000');

INSERT INTO `to_movimiento_conciliacion` (`id`, `id_conciliacion`, `created_by`, `created_date`, `nuevo`) VALUES ('1', '1', 'NMP', '2019-05-08 22:53:22', '1');
INSERT INTO `to_movimiento_conciliacion` (`id`, `id_conciliacion`, `created_by`, `created_date`, `nuevo`) VALUES ('2', '1', 'NMP', '2019-05-08 22:53:22', '1');
INSERT INTO `to_movimiento_conciliacion` (`id`, `id_conciliacion`, `created_by`, `created_date`, `nuevo`) VALUES ('3', '1', 'NMP', '2019-05-08 22:53:22', '1');
INSERT INTO `to_movimiento_conciliacion` (`id`, `id_conciliacion`, `created_by`, `created_date`, `nuevo`) VALUES ('4', '1', 'NMP', '2019-05-08 22:53:22', '1');
INSERT INTO `to_movimiento_conciliacion` (`id`, `id_conciliacion`, `created_by`, `created_date`, `nuevo`) VALUES ('5', '1', 'NMP', '2019-05-08 22:53:22', '1');
INSERT INTO `to_movimiento_conciliacion` (`id`, `id_conciliacion`, `created_by`, `created_date`, `nuevo`) VALUES ('6', '1', 'NMP', '2019-05-08 22:53:22', '1');

INSERT INTO `to_movimiento_comision` (`id`, `fecha_operacion`, `fecha_cargo`, `monto`, `descripcion`, `estatus`)
VALUES ('1', '2019-05-21', '2019-05-08', '123.0000', 'string', '1');
INSERT INTO `to_movimiento_comision` (`id`, `fecha_operacion`, `fecha_cargo`, `monto`, `descripcion`, `estatus`)
VALUES ('2', '2019-05-08', '2019-05-08', '123.0000', '123.0000', '1');

INSERT INTO `to_reporte` (`id`, `id_conciliacion`, `tipo`, `disponible`, `fecha_desde`, `fecha_hasta`, `created_date`, `created_by`)
VALUES ('1', '1', 'MIDAS', '1', '2019-05-18', '2019-05-18', '2019-05-18 20:44:43', 'Sistema');
INSERT INTO `to_reporte` (`id`, `id_conciliacion`, `tipo`, `disponible`, `fecha_desde`, `fecha_hasta`, `created_date`, `created_by`)
VALUES ('2', '1', 'PROVEEEDOR', '1', '2019-05-18', '2019-05-18', '2019-05-18 20:44:43', 'Sistema');
INSERT INTO `to_reporte` (`id`, `id_conciliacion`, `tipo`, `disponible`, `fecha_desde`, `fecha_hasta`, `created_date`, `created_by`)
VALUES ('3', '1', 'ESTADO_CUENTA', '1', '2019-05-18', '2019-05-18', '2019-05-18 20:44:43', 'Sistema');

INSERT INTO `to_movimiento_devolucion` (`id`, `estatus`, `fecha`, `monto`, `esquema_tarjeta`, `identificador_cuenta`, `titular`, `codigo_autorizacion`, `sucursal`)
VALUES ('5', true, '2019-05-16', '123.0000', '123', '123', 'dasd', '3123', '3123');
INSERT INTO `to_movimiento_devolucion` (`id`, `estatus`, `fecha`, `monto`, `esquema_tarjeta`, `identificador_cuenta`, `titular`, `codigo_autorizacion`, `sucursal`)
VALUES ('6', true, '2019-05-16', '123.0000', '123', '123', 'dasd', '3123', '3123');
