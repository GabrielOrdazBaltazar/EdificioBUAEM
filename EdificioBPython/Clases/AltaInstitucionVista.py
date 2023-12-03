import tkinter as tk
from Clases import Institucion, InstitucionSQL

class AltaInstitucionVista:
    def __init__(self):
        self.root = tk.Tk()
        self.root.title("Alta Institucion")

        self.label1 = tk.Label(self.root, text="Alta Institucion")
        self.label1.pack()

        self.label2 = tk.Label(self.root, text="Nombre:")
        self.label2.pack()

        self.txtNombre = tk.Entry(self.root)
        self.txtNombre.pack()

        self.btnGuardar = tk.Button(self.root, text="Guardar", command=self.guardar_institucion)
        self.btnGuardar.pack()

        self.root.mainloop()

    def guardar_institucion(self):
        nombre = self.txtNombre.get()
        # Instanciamos objeto Institucion
        institucion = Institucion(nombre)
        # Instanciamos institucionSQL
        institucionSQL = InstitucionSQL()
        institucionSQL.ingresar_institucion(institucion)

        self.txtNombre.delete(0, tk.END)  # Limpiar el cuadro de texto después de guardar

if __name__ == "__main__":
    alta_institucion_vista = AltaInstitucionVista()
