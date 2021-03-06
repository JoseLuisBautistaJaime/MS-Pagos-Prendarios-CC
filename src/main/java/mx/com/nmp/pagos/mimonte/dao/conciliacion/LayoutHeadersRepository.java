/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dao.conciliacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.nmp.pagos.mimonte.model.conciliacion.LayoutHeader;

/**
 * @name LayoutHeadersRepository
 * @description Interface de tipo repository que contiene metodos para realizar
 *              operaciones a nivel de base de datos sobre objetos relacionados
 *              con LayoutHeaders.
 *
 * @author Quarksoft
 * @creationDate 23-05-2019
 * @version 0.1
 */
@Repository
public interface LayoutHeadersRepository extends JpaRepository<LayoutHeader, Long> {

	public LayoutHeader findByLayoutId(Long idLayout);

}
