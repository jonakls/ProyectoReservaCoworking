package top.jonakls.projectcoworking.entity.workspace;

public enum BookingWorkspace {
    ESCRITORIO(1, "Escritorio"),
    SALA_REUNIONES(2, "Sala de reuniones"),
    SALA_CONFERENCIAS(3, "Sala de conferencias");

    private final int id;
    private final String name;

    BookingWorkspace(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static BookingWorkspace fromId(int id) {
        for (BookingWorkspace workspace : values()) {
            if (workspace.getId() == id) {
                return workspace;
            }
        }
        return null;
    }
}
