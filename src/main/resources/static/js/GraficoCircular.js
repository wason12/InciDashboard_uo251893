class GraficoCircular{


    constructor(incidencias, id){
        this.data = [];
        this.grafico = null;
        this.incidencias = incidencias;

        this.crearData();
        this.procesarIncidencias();
        this.crearGrafico(id);
    }

    crearData(){
        this.data = [{
            label: "ABIERTAS",
            data: 0
        }, {
            label: "CERRADAS",
            data: 0
        }, {
            label: "EN PROCESO",
            data: 0
        }, {
            label: "ANULADAS",
            data: 0
        }];
    }

    crearGrafico(id){
        this.grafico = $.plot($(id), this.data, {
            series: {
                pie: {
                    show: true
                }
            },
            grid: {
                hoverable: true
            },
            tooltip: true,
            tooltipOpts: {
                content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
                shifts: {
                    x: 20,
                    y: 0
                },
                defaultTheme: false
            }
        });
    }

    procesarIncidencias(){
        for(var i = 0 ; i< this.incidencias.length ; i++)
            this.actualizarData(this.incidencias[i], 1);
    }

    actualizar(incidencia){
        var index = this.indexOf(incidencia);
        if( index != -1 ) {
            this.actualizarData(this.incidencias[index], -1);
            this.incidencias[index] = incidencia;
        }
        else
            this.incidencias.push(incidencia);
        this.actualizarData(incidencia, 1);

        this.grafico.setData(this.data);
        this.grafico.draw();
    }

    actualizarData(incidencia, i){
        if(incidencia.estado == "ABIERTA")
            this.data[0].data += i;
        else if(incidencia.estado == "CERRADA")
            this.data[1].data += i;
        else if(incidencia.estado == "EN_RPOCESO")
            this.data[2].data += i;
        else if(incidencia.estado == "ANULADA")
            this.data[3].data += i;
    }

    indexOf(incidencia){
        for(var i = 0 ; i<this.incidencias.length ; i++)
            if(incidencia.id == this.incidencias[i].id)
                return i;

        return -1;
    }

}