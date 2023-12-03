# Importar las clases necesarias desde el módulo (asegúrate de tenerlas definidas)
from Clases import Institucion, InstitucionSQL
import os

# Change the working directory to the directory containing your main script
os.chdir(os.path.dirname(os.path.abspath(__file__)))
# Clase de la vista
class AltaInstitucionVista:
    def __init__(self):
        self.init_components()

    def init_components(self):
        # ... (código de inicialización de componentes aquí)
        pass

    def btn_guardar_action_performed(self, evt):
        nombre = self.txt_nombre.get()  # Asegúrate de que la entrada tenga un nombre txt_nombre
        # Instanciamos objeto Institucion
        institucion = Institucion(nombre)
        # Instanciamos institucionSQL
        institucion_sql = InstitucionSQL()
        institucion_sql.ingresarInstitucion(institucion)
        self.txt_nombre.delete(0, 'end')  # Limpiamos la entrada después de guardar

    def main(self):
        self.init_components()
        # Establecer la ventana visible
        self.root.mainloop()

# Crear una instancia de la vista y ejecutar el programa
if __name__ == "__main__":
    alta_institucion_vista = AltaInstitucionVista()
    alta_institucion_vista.main()
