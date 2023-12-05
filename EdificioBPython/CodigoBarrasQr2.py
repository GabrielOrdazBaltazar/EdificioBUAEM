import cv2
from pyzbar.pyzbar import decode

# Función para decodificar códigos de barras y códigos QR en una imagen
def decode_barcodes(frame):
    barcodes = decode(frame)
    
    if barcodes:
        # Si se detecta al menos un código
        barcode = barcodes[0]
        barcode_data = barcode.data.decode('utf-8')
        barcode_type = barcode.type
        print(f'Código detectado: {barcode_data}, Tipo: {barcode_type}')
        return barcode_data, barcode_type, barcode
    else:
        # Si no se detecta ningún código
        return None, None, None

# Inicializar la captura de la webcam
cap = cv2.VideoCapture(0)

while True:
    # Capturar un frame de la webcam
    ret, frame = cap.read()

    # Decodificar códigos de barras y códigos QR
    barcode_data, barcode_type, barcode = decode_barcodes(frame)

    # Dibujar un rectángulo alrededor del código de barras o código QR
    if barcode_data is not None:
        rect_points = barcode.polygon
        if rect_points and len(rect_points) == 4:
            rect_points = [(point.x, point.y) for point in rect_points]
            rect_points = tuple(map(lambda point: (int(point[0]), int(point[1])), rect_points))
            cv2.polylines(frame, [rect_points], isClosed=True, color=(0, 255, 255), thickness=2)

    # Mostrar el frame con el código de barras o código QR y el rectángulo
    cv2.imshow('Webcam', frame)

    # Romper el bucle si se presiona la tecla 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Liberar los recursos
cap.release()
cv2.destroyAllWindows()
