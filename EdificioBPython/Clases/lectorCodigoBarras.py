import cv2
from pyzbar.pyzbar import decode

# Función para decodificar códigos de barras en una imagen
def decode_barcodes(frame):
    barcodes = decode(frame)
    for barcode in barcodes:
        barcode_data = barcode.data.decode('utf-8')
        print(f'Código de barras detectado: {barcode_data}')
        return barcode_data  # Puedes devolver o procesar más el resultado aquí si es necesario

# Inicializar la captura de la webcam
cap = cv2.VideoCapture(0)

while True:
    # Capturar un frame de la webcam
    ret, frame = cap.read()

    # Decodificar códigos de barras
    barcode_data = decode_barcodes(frame)

    # Dibujar un rectángulo alrededor del código de barras
    for barcode in decode(frame):
        rect_points = barcode.polygon
        if len(rect_points) == 4:
            rect_points = rect_points[0], rect_points[2]
            rect_points = tuple(map(lambda point: (point[0], point[1]), rect_points))
            cv2.polylines(frame, [rect_points], isClosed=True, color=(0, 255, 255), thickness=2)

    # Mostrar el frame con el código de barras y el rectángulo
    cv2.imshow('Webcam', frame)

    # Romper el bucle si se presiona la tecla 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Liberar los recursos
cap.release()
cv2.destroyAllWindows()


