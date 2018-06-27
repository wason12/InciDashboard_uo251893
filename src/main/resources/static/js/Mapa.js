class Mapa{

    constructor(incidencias,id){
        this.mapa = null;
        this.incidencias = null;
        this.ventanasInformativas = [];

        this.incidencias = incidencias;
        $(document).ready(this.inicializarMapa(id));
    }

    inicializarMapa(id){
        var espanya = new google.maps.LatLng(40.4167, -3.70325);

        this.mapa = new google.maps.Map(document.getElementById(id), {
            center: espanya,
            zoom: 6
        });

        this.procesarIncidencias();

        this.mapa.addListener('zoom_changed', function () {
            for(var i = 0 ; i<vista.mapa.ventanasInformativas.length ; i++){
                vista.mapa.ventanasInformativas[i].open(vista.mapa.mapa);
            }
        });

    }

    procesarIncidencias(){
        for( var i = 0 ; i< this.incidencias.length ; i++)
            this.parsear(this.incidencias[i]);
    }

    parsear(incidencia){

        var coordInfoWindow = new google.maps.InfoWindow();
        coordInfoWindow.setContent(this.createInfoWindowContent(incidencia, this.mapa.getZoom()));
        coordInfoWindow.setPosition(new google.maps.LatLng(incidencia.localizacion.latitud, incidencia.localizacion.longitud));
        coordInfoWindow.open(this.mapa);


        this.ventanasInformativas.push(coordInfoWindow);
    }

    createInfoWindowContent(incidencia){
        return [
            'Nombre: ' + incidencia.name,
            'Descripcion: ' + incidencia.descripcion,
            'Estado: ' + incidencia.estado
        ].join('<br>');
    }

    actualizar(incidencia){
        var index = this.indexOf(incidencia);
        if(index == -1)
            this.parsear(incidencia);
        else{
            this.ventanasInformativas[index].setContent(this.createInfoWindowContent(incidencia));
            this.ventanasInformativas[index].open(this.mapa);
        }
    }

    indexOf(incidencia){
        for(var i = 0 ; i<this.incidencias.length ; i++)
            if(incidencia.id == this.incidencias[i].id)
                return i;

        return -1;
    }


}