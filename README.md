## DEFINICIÓN MÉTODOS HTTP
* **GET**: Solicita datos del servidor.
* **POST**: Añade información en el servidor.
* **PUT**: Reemplaza información de todo un registo en el servidor.
* **DELETE**: Elimina información del servidor.
* **PATCH**: Actualiza información parcial de un registro en el servidor.
* **HEAD**: Recupera los encabezados de una solicitud sin mostrar información del registro.

## DEFINICIÓN DE ANOTACIONES
* `@RestController` (Es un controlador RESTful web services utilizado para manejar solicitudes HTTP y devolver respuestas en formato JSON o XML)
* `@RequestMapping("Item")` (Usada para mapear peticiones HTTP a métodos en específicos de una clase, en este caso establería la ruta base en la URL)
* `@Autowired` (Permite hacer la inyección automática de dependencias o intancias en Spring para así evitar la necesidad de instanciar un objeto nuevamente)

### Explicación del siguiente fragmento
    public GroceryItem() {
    }

    public GroceryItem(String id, String name, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
Estos dos fragmentos de código se tratan de constructores que permiten crear un objeto. La diferencia recae en la inicialización de sus atributos; en el caso del primero, los objetos no tienen la necesidad de especificar sus atributos, mientras que en el otro, sí los inicializa con valores especificos.
Por lo tanto, se concluye que hay la posibilidad de crear objetos con y sin atributos, teniendo en cuenta que estos últimos tendrán valores por defectos (normalmente null para cadenas de texto, 0 para enteros, etc.).

Por último, la etiqueta `@Override` indica que el siguiente método está sobreescribiendo un método ya creado de una superclase en Java, y así poder anexarle sus propias características.

