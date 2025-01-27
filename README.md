<h1 align="center">📚 Foro con Seguridad JWT</h1>
<p align="center">Un foro básico con autenticación basada en JWT (JSON Web Tokens) que permite la creación, edición y eliminación de temas. ¡Seguro y fácil de usar! 🔒</p>

---

<h2>🚀 Funcionalidad del Programa</h2>
<ul>
  <li><strong>Autenticación JWT</strong>: 🔑 Autenticación stateless basada en tokens para garantizar seguridad.</li>
  <li><strong>Gestión de Temas</strong>: 📝 Crear, listar, editar y eliminar (lógicamente) temas en el foro.</li>
  <li><strong>Gestión de Usuarios</strong>: 👤 Registrar nuevos usuarios en el sistema.</li>
  <li><strong>Paginación de Temas</strong>: 📄 Listar temas de forma paginada para una mejor organización.</li>
</ul>

---

<h2>🛠️ Conocimientos Básicos Aplicados</h2>
<ul>
  <li><strong>Spring Boot</strong>: 🖥️ Uso de Spring para la creación de APIs RESTful.</li>
  <li><strong>Autenticación JWT</strong>: 🔒 Implementación de seguridad basada en tokens.</li>
  <li><strong>Base de Datos</strong>: 🗄️ Uso de JPA y repositorios para persistencia de datos.</li>
  <li><strong>Validación de Datos</strong>: ✅ Validación de entradas mediante anotaciones como <code>@Valid</code>.</li>
  <li><strong>Paginación</strong>: 📑 Uso de <code>Pageable</code> para listar temas de forma paginada.</li>
</ul>

---

<h2>🎯 Cómo Utilizar</h2>

<h3>1. Autenticación</h3>
<ul>
  <li><strong>Endpoint</strong>: <code>POST /login</code></li>
  <li><strong>Descripción</strong>: Autentica a un usuario y genera un token JWT.</li>
  <li><strong>Body</strong>:
    <pre>
    {
      "email": "usuario@example.com",
      "password": "contraseña"
    }
    </pre>
  </li>
  <li><strong>Respuesta</strong>: Devuelve un token JWT para usar en solicitudes protegidas.</li>
</ul>

<h3>2. Registro de Usuarios</h3>
<ul>
  <li><strong>Endpoint</strong>: <code>POST /usuario</code></li>
  <li><strong>Descripción</strong>: Registra un nuevo usuario en el sistema.</li>
  <li><strong>Body</strong>:
    <pre>
    {
      "nombre": "Nombre del Usuario",
      "email": "usuario@example.com",
      "password": "contraseña"
    }
    </pre>
  </li>
  <li><strong>Respuesta</strong>: Devuelve los datos del usuario registrado.</li>
</ul>

<h3>3. Gestión de Temas</h3>
<ul>
  <li><strong>Crear Tema</strong>:
    <ul>
      <li><strong>Endpoint</strong>: <code>POST /tema</code></li>
      <li><strong>Descripción</strong>: Crea un nuevo tema en el foro.</li>
      <li><strong>Body</strong>:
        <pre>
        {
          "titulo": "Título del Tema",
          "mensaje": "Contenido del Tema",
          "idUsuario": 1
        }
        </pre>
      </li>
    </ul>
  </li>
  <li><strong>Listar Temas</strong>:
    <ul>
      <li><strong>Endpoint</strong>: <code>GET /tema</code></li>
      <li><strong>Descripción</strong>: Lista todos los temas de forma paginada.</li>
    </ul>
  </li>
  <li><strong>Mostrar un Tema</strong>:
    <ul>
      <li><strong>Endpoint</strong>: <code>GET /tema/{id}</code></li>
      <li><strong>Descripción</strong>: Muestra los detalles de un tema específico.</li>
    </ul>
  </li>
  <li><strong>Editar Tema</strong>:
    <ul>
      <li><strong>Endpoint</strong>: <code>PUT /tema</code></li>
      <li><strong>Descripción</strong>: Actualiza un tema existente.</li>
      <li><strong>Body</strong>:
        <pre>
        {
          "idTema": 1,
          "titulo": "Nuevo Título",
          "mensaje": "Nuevo Mensaje",
          "idUsuario": 1
        }
        </pre>
      </li>
    </ul>
  </li>
  <li><strong>Eliminar Tema</strong>:
    <ul>
      <li><strong>Endpoint</strong>: <code>DELETE /tema/{id}</code></li>
      <li><strong>Descripción</strong>: Desactiva un tema (eliminación lógica).</li>
    </ul>
  </li>
</ul>

---

<h2>🔒 Seguridad</h2>
<ul>
  <li><strong>Autenticación JWT</strong>: Todas las operaciones relacionadas con temas requieren un token JWT válido.</li>
  <li><strong>Stateless</strong>: No se almacena estado en el servidor, lo que permite escalabilidad.</li>
</ul>

---

<p align="center">¡Y eso es todo! 🎉 Con este foro, puedes gestionar temas de manera segura y eficiente. 🚀</p>
