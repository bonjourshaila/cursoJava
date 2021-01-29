<template>
  <div>
    <b-container>
      <b-row>
        <div>
          <h1><b-badge variant="primary">Productos</b-badge></h1>
          <br />
          <br />
          <br />
        </div>

        <b-col cols="12">
          <b-button variant="primary" @click="agregar()"
            >Agregar producto</b-button
          >
          <br />
          <br />
        </b-col>

        <b-col cols="12">
          <b-alert v-if="guardado" variant="success" show
            >Success Alert</b-alert
          >
        </b-col>
        <b-col>
          <div>
            <b-table striped hover :items="datos" :fields="fields">
              <template v-slot:cell(Acciones)="row">
                <b-button-group>
                  <b-button variant="warning" @click="editar(row.item)"
                    >Editar</b-button
                  >
                  <b-button
                    v-if="row.item.activo"
                    variant="danger"
                    @click="eliminar(row.item)"
                    >Eliminar</b-button
                  >
                  <b-button v-else variant="info" @click="eliminar(row.item)"
                    >Restaurar</b-button
                  >
                </b-button-group>
              </template>
            </b-table>
          </div>
        </b-col>
      </b-row>
    </b-container>

    <b-modal v-model="show" id="modal-1" title="Producto:">
      <b-container>
        <b-row>
          <b-col>
            <b-form-group
              label-cols="4"
              label-cols-lg="2"
              label="Nombre"
              label-for="input-default"
            >
              <b-form-input
                id="input-live"
                v-model="producto.nombre"
                aria-describedby="input-live-help input-live-feedback"
                placeholder="Nombre  producto"
                trim
              ></b-form-input>
            </b-form-group>
            <br />

            <b-form-group
              label-cols="4"
              label-cols-lg="2"
              label="Tipo"
              label-for="input-default"
            >
              <b-form-select v-model="producto.idTipoProducto">
                <b-form-select-option :value="null"
                  >Selecciona una opción</b-form-select-option
                >
                <b-form-select-option
                  v-for="tipo in tipoProducto"
                  :key="tipo.idTipoProducto"
                  :value="tipo.idTipoProducto"
                  >{{ tipo.nombre }}</b-form-select-option
                >
              </b-form-select>
            </b-form-group>
          </b-col>
        </b-row>
      </b-container>
      <div slot="modal-footer">
        <b-button
          variant="outline-primary"
          :disabled="loaderAcciones"
          @click="guardar()"
        >
          <span v-if="!loaderAcciones">Guardar</span>
          <span v-if="loaderAcciones">
            <b-spinner small></b-spinner>
            Cargando...
          </span>
        </b-button>
        <b-button
          variant="outline-danger"
          :disabled="loaderAcciones"
          @click="cerrarModal()"
          >Cancelar</b-button
        >
      </div>
    </b-modal>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  data: () => {
    return {
      datos: [],
      ejemplo: [],
      fields: [
        { key: "idProducto", label: "#" },
        { key: "nombre", label: "Nombre del producto" },
        { key: "idTipoProducto", label: "Tipo producto" },
        "Acciones",
      ],
      show: false,
      loaderAcciones: false,
      producto: {
        idProducto: null,
        nombre: null,
        idTipoProducto: null,
      },
      selected: null,
      tipoProducto: {
        idTipoProducto: null,
        nombreTipoProducto: null,
      },
      guardado: false,
    };
  },
  created() {
    this.obtenerProductos();
  },
  mounted() {
    this.obtenerTipoProducto();
  },
  methods: {
    obtenerProductos() {
      this.$http.get(this.$api + "producto/obtener").then((respuesta) => {
        this.datos = respuesta.data.data;
      });
    },
    obtenerTipoProducto() {
      this.$http
        .get(this.$api + "producto/obtenerTipoProducto")
        .then((respuesta) => {
          this.tipoProducto = respuesta.data.data;
        });
    },
    agregar() {
      this.show = true;
      this.producto = {
        idProducto: null,
        nombre: null,
        idTipoProducto: null,
      };
    },
    editar(dato) {
      (this.producto = dato),
        (this.tipoProducto.idTipoProducto = dato),
        (this.show = true);
    },
    eliminar(dato) {
      this.$http
        .delete(this.$api + "producto/eliminar?idProducto=" + dato.idProducto)
        .then((respuesta) => {
          if (respuesta.data.data) {
            this.guardado = true;
            setTimeout(() => (this.guardado = false), 10000);
            this.obtenerProductos();
          }
        })
        .finally();
    },
    cerrarModal() {
      this.show = false;
    },
    guardar() {
      this.loaderAcciones = true;
      this.$http
        .post(this.$api + "producto/guardar", this.producto)
        .then((respuesta) => {
          console.log(respuesta);
          this.guardado = true;
          setTimeout(() => (this.guardado = false), 10000);
          this.show = false;
          this.obtenerProductos();
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          this.loaderAcciones = false;
        });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
