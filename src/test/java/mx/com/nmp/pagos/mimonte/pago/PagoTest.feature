Feature: MS Pagos
	Background:
		* url 'http://localhost:8080'
		* header Accept = 'application/json'
	Scenario: Registrar un pago
		Given path 'mimonte/v1/pago'
		And request {"concepto": "Pago de partidas NEW X33","guardaTarjeta": true,"idCliente": 14996661122,"idTransaccionMidas": "6659987521114","montoTotal": 10000.1233,"operaciones": [{"folioContrato": "103334","idOperacion": 148,"monto": 5000,"nombreOperacion": "Refrendo A4"},{"folioContrato": "222334","idOperacion": 8,"monto":5000.1233,"nombreOperacion": "Refrendo B4"}],"tarjeta": {"alias": "kinder","digitos": "7886","estatus": {"id": 2},"fechaAlta": null,"fechaModificacion": null,"id_openpay": "IDOP60XXX01666223333","tipo": {"id": 1},"token": "TOK3N6XX6669090333"}}
		When method POST
		Then status 200
