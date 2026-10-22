# Barbería Mero Estilo

Aplicación de consola en Java para gestionar clientes, barberos, servicios y citas de una barbería, con validación de horarios para evitar reservas que se crucen.

## Product Goal (meta del producto)
Disponer de una aplicación de consola funcional que facilite la organización de clientes, barberos, servicios y citas de la barbería, aplicando reglas de negocio y herramientas fundamentales de Java, con una estructura sencilla, comprensible, verificable y ampliable.

## Equipo y responsabilidades
| Integrante | Rol Scrum | Historias |
|---|---|---|
| Sánchez Reyes | Product Owner (dueño del producto) | HU-03, HU-10, HU-11 |
| López Moncada | Scrum Master (facilitador) | HU-01, HU-07, HU-13 |
| Castellanos Cuervo | Developer (desarrollador) y pruebas | HU-02, HU-04, HU-06, HU-08 |
| Jiménez Gómez | Developer (desarrollador) | HU-05, HU-09, HU-12 |

Los cuatro integrantes programan, revisan Pull Requests y pueden explicar cualquier parte del proyecto.

## Alcance
- **Incluye:** registro y consulta de clientes, barberos y servicios; agendar citas con validación de cruces de horario; consultar agendas; cancelar y atender citas; reporte de ingresos; validación de entradas.
- **No incluye:** interfaz gráfica, base de datos, inicio de sesión, pagos, notificaciones ni persistencia en archivos.
- **Almacenamiento:** los datos se guardan en memoria mientras el programa está abierto.

## Sprints
| Sprint | Sprint Goal (meta del sprint) | Historias |
|---|---|---|
| 1 | Registrar clientes, barberos y servicios desde un menú de consola ejecutable | HU-01 a HU-04 |
| 2 | Agendar y consultar citas sin cruces de horario | HU-05 a HU-10 |
| 3 | Cancelar, atender, calcular ingresos y dejar el producto probado y entregable | HU-11 a HU-13 |

## Definition of Done (definición de terminado)
Una historia está terminada solo si:
1. Cumple todos sus criterios de aceptación.
2. El código compila y la función puede ejecutarse.
3. Se probaron los casos normales y los casos límite.
4. Otro integrante revisó el Pull Request y se integró en `main`.
5. La Issue y el Pull Request están enlazados.
6. Este README sigue describiendo correctamente cómo ejecutar el proyecto.
7. El equipo puede explicar las decisiones y el código incorporado.

## Estructura del proyecto
```text
src/
├── Main.java
├── modelos/        Cliente, Barbero, Servicio, Cita
├── servicios/      GestorClientes, GestorBarberos, GestorServicios, GestorCitas, GestorReportes
├── menus/          MenuAdministrador, MenuBarbero, MenuCliente
└── utilidades/     Validador
pruebas/
└── CasosPrueba.md
```

## Cómo compilar y ejecutar
Requisito: JDK 21 instalado. Se completa cuando exista el esqueleto del proyecto.

## Seguimiento
- Tablero del proyecto: [pegar aquí el enlace del Project]
- Issues: pestaña Issues de este repositorio
- Pruebas: `pruebas/CasosPrueba.md`
