import cv2
import numpy as np
from pyzbar.pyzbar import decode
import tkinter as tk
from tkinter import messagebox

# Función para decodificar códigos de barras y códigos QR en una imagen
def decode_barcodes(frame):
    barcodes = decode(frame)
    
    if barcodes:
        # Si se detecta al menos un código
        barcode = barcodes[0]
        barcode_data = barcode.data.decode('utf-8')
        barcode_type = barcode.type
        return barcode_data, barcode_type, barcode
    else:
        # Si no se detecta ningún código
        return None, None, None

# Función para mostrar el resultado en una ventana de Tkinter
def show_result(barcode_data, barcode_type):
    result_text = f'Código detectado: {barcode_data}, Tipo: {barcode_type}'
    messagebox.showinfo('Resultado', result_text)

# Inicializar la captura de la webcam
cap = cv2.VideoCapture(0)

# Crear una ventana de Tkinter
root = tk.Tk()
root.withdraw()  # Ocultar la ventana principal de Tkinter

while True:
    # Capturar un frame de la webcam
    ret, frame = cap.read()

    # Decodificar códigos de barras y códigos QR
    barcode_data, barcode_type, _ = decode_barcodes(frame)

    # Mostrar el frame con el código de barras o código QR
    cv2.imshow('Webcam', frame)

    # Mostrar el resultado en la ventana de Tkinter
    if barcode_data is not None:
        show_result(barcode_data, barcode_type)

    # Romper el bucle si se presiona la tecla 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Liberar los recursos
cap.release()
cv2.destroyAllWindows()


