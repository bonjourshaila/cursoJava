package com.curso.softura.curso.helper;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FechasHelper implements Serializable {

    private static final long serialVersionUID = 815025598371198550L;

    public static ZonedDateTime obtenerFechaActual() {
        final Instant instant = Instant.now();
        return instant.atZone(ZoneId.of("UTC"));
    }

}
