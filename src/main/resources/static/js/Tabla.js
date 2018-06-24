class Tabla{

    constructor(incidencias, id){
        this.dataset = [];
        this.colums = [
            { title: "ID" },
            { title: "Nombre" },
            { title: "Descripción" },
            { title: "MasInfo" },
            { title: "Etiquetas" },
            { title: "Campos" },
            { title: "Localizacion" },
            { title: "Estado" },
            { title: "Cambiar Estado" }
        ];
        this.tabla = null;

        this.procesarIncidencias(incidencias);
        this.crearTabla(id);
    }

    crearTabla(id){
        this.tabla = $(id).DataTable( {
            data: this.dataset,
            columns: this.colums
        } );
    }

    procesarIncidencias(incidencias){
        for(var i = 0 ; i< incidencias.length ; i++){
            this.dataset[i] = this.parsear(incidencias[i]);
        }
    }

    parsear(incidencia){
        var fila = [];
        fila[0] = incidencia.id;
        fila[1] = incidencia.name;
        fila[2] = incidencia.descripcion;

        var url = "no";
        if(incidencia.urlMasInfo != null){
            var href = "http://localhost:80/fotossubidas/" + incidencia.id + ".jpg";
            url = "<a href=" + href + ">mas info</a>"
        }
        fila[3] = url;

        var etiquetas = "";
        for( var i = 0 ; i< incidencia.etiquetas.length ; i++)
            etiquetas += incidencia.etiquetas[i] + ",";
        fila[4] = etiquetas;

        var campos = "";
        var obj = incidencia.campos;
        for( var key in obj)
            campos += key + "/" + obj[key] + ",";
        fila[5] = campos;

        fila[6] = incidencia.localizacion.latitud + "-" + incidencia.localizacion.longitud;
        fila[7] = incidencia.estado;
        fila[8] = "<button>cambiar</button>"

        return fila;
    }

    incidenciaYaRegistrada(incidencia){
        for(var i = 0 ; i<this.dataset.length ; i++)
            if(incidencia.id == this.dataset[i][0])
                return i;

        return -1;
    }

    actualizar(incidencia){
        var index = this.incidenciaYaRegistrada(incidencia);
        if( index == -1) {
            this.dataset.push(this.parsear(incidencia));
            this.tabla.row.add(this.parsear(incidencia)).draw();
        }
        else {
            this.dataset[index] = this.parsear(incidencia);
            this.tabla.row(function (idx, data, node) { return data[0] == incidencia.id  }).data(this.parsear(incidencia)).draw();
        }


    }



}