import psycopg2
from tkinter import messagebox
from Clases import ConexionSQL, Institucion

class InstitucionSQL(ConexionSQL):
    def __init__(self):
        super().__init__()
        self.id_institucion = 0
        self.st = None
        self.rs = None
    
    def ingresar_institucion(self, institucion):
        try:
            # Ingresar datos a la base de datos
            conexion = self.conectar()
            self.st = conexion.cursor()
            sql = f"INSERT INTO institucion(nombre) VALUES ('{institucion.getNombre()}');"
            self.st.execute(sql)
            conexion.commit()
            self.st.close()
            conexion.close()

            messagebox.showinfo("Mensaje", "El registro se guardó correctamente")
        except Exception as e:
            messagebox.showerror("Mensaje", f"El registro no se guardó: {e}")
            print(e)

    def buscar_institucion(self, id_institucion):
        institucion = Institucion()
        try:
            conexion = self.conectar()
            self.st = conexion.cursor()
            sql = f"SELECT * FROM institucion WHERE id_institucion = {id_institucion};"
            self.st.execute(sql)
            result = self.st.fetchone()

            if result:
                institucion.setNombre(result[1])
            else:
                messagebox.showinfo("Sin registro", "No se encontró registro")
            
            self.st.close()
            conexion.close()
        except Exception as e:
            messagebox.showerror("Error", f"Error en el sistema de búsqueda: {e}")

        return institucion

