# Apium Academy Application

Queremos desarrollar una plataforma de e-learning para impartir los cursos de nuestra empresa "Apium Academy".

Para ello, necesitamos desarrollar una aplicación con Springboot que nos permita gestionar los cursos, a los usuarios,
los pagos y el contenido multimedia.

Los requisitos son los siguientes:

### Gestión de usuarios

- Cuando un usuario se registra en la plataforma se le asigna automáticamente el rol de estudiante.
- Un administrador puede convertir a ese usuario en profesor.
- Un usuario puede ser a la vez estudiante y profesor.
- Sólo los profesores pueden crear cursos, y sólo los estudiantes pueden inscribirse en ellos.
- Un estudiante puede consultar en qué cursos está inscrito.
- Un profesor puede consultar qué cursos tutoriza.

### Gestión de cursos

- Un curso siempre será creado por un profesor.
- Al crear un curso, se debe indicar un número máximo de alumnos que pueden inscribirse en el, así como el precio del
  mismo.
- Un curso se corresponde de un número indeterminado de lecciones, las cuales pueden añadirse tras crear el curso.
- Hay dos tipos de lecciones, gratuitas y de pago, ya que queremos ofrecer un modelo freemium.
- Un curso tendrá siempre un director, y puede tener 0..N tutores. Todos ellos tendrán que ser profesores en la
  plataforma.
- Los tutores tendrán acceso al curso y podrán corregir actividades, pero no podrán editar el contenido, esto sólo lo
  podrá hacer el director.
- Un curso tiene una fecha de inicio y una fecha de fin, a partir de la cual el contenido seguirá siendo accesible pero
  las actividades (exámenes) no podrán ser realizadas.

### Gestión de actividades y evaluaciones

- Asociada a cada lección, existirá una actividad evaluable, que tendrá que ser realizada por los alumnos.
- Las actividades pueden ser de tipo test o de desarrollo de contenido.
- Según el tipo de actividad, serán autoevaluables o deberán ser corregidas por un tutor del curso.
- Un alumno superará el curso si ha superado con éxito todas las actividades.

### Gestión de contenido multimedia

- Las lecciones pueden enlazar contenido multimedia de diferentes tipos. Imágenes, vídeos, audio...
- Este contenido se quiere poder gestionar internamente, teniendo que permitir la subida de archivos de los tipos
  mencionados anteriormente.

### Gestión de pagos

- Los estudiantes tienen que poder pagar para acceder a los cursos que deseen

### Administración

- El administrador puede asignar roles a los usuarios, siendo estos estudiantes, profesores y/o administradores
- El administrador puede modificar cualquier tipo de información de los usuarios, cursos, lecciones, contenido
  multimedia o pagos.

Authentication with jwt and roles in SpringBoot 3.x article:

(1) -
Authentication https://medium.com/@tericcabrel/implement-jwt-authentication-in-a-spring-boot-3-application-5839e4fd8fac

(2) - RBAC https://medium.com/@tericcabrel/implement-role-based-access-control-in-spring-boot-3-a31c87c2be5c
