package top.jonakls.projectcoworking.entity.workspace;

/**
 * Enumerado que representa los espacios de trabajo que se pueden reservar.
 * Cada espacio tiene un identificador y un nombre.
 */
public enum BookingWorkspace {
    ESCRITORIO(1, "Escritorio"),
    SALA_REUNIONES(2, "Sala de reuniones"),
    SALA_CONFERENCIAS(3, "Sala de conferencias");

    private final int id;
    private final String name;

    /**
     * Constructor de la clase.
     *
     * @param id   Identificador del espacio de trabajo.
     * @param name Nombre del espacio de trabajo.
     */
    BookingWorkspace(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Metodo que devuelve el identificador del espacio de trabajo.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que devuelve el nombre del espacio de trabajo.
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que devuelve el espacio de trabajo a partir de su identificador.
     *
     * @param id Identificador del espacio de trabajo.
     */
    public static BookingWorkspace fromId(int id) {
        for (BookingWorkspace workspace : values()) {
            if (workspace.getId() == id) {
                return workspace;
            }
        }
        return null;
    }
}
