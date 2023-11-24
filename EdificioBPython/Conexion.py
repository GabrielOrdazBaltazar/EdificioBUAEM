import psycopg2
from tkinter import messagebox

class ConexionSQL:
    def __init__(self):
        self.conn = None
        self.url = "dbname=bdedificiob user=postgres password=tachyeldragon123 host=localhost port=5432"
    
    def conectar(self):
        try:
            self.conn = psycopg2.connect(self.url)
            return self.conn
        except Exception as e:
            messagebox.showerror("Error", f"Error al conectar: {e}")
            return None
