class Vista {

    constructor(incidencias){
        this.mapa = null;
        this.graficoCircular = null;
        this.tabla = null;

        this.mapa = new Mapa(incidencias, "map");
        this.graficoCircular = new GraficoCircular(incidencias, "#flot-pie-chart");
        this.tabla = new Tabla(incidencias, "#tabla-incidencias");
    }

    actualizar(incidencia){
        this.mapa.actualizar(incidencia);
        this.graficoCircular.actualizar(incidencia);
        this.tabla.actualizar(incidencia);
    }

}