export const convertImageToWebP = (file) => {
    return new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.onload = (event) => {
        const img = new Image();
        img.src = event.target.result;
  
        img.onload = () => {
          // Crear un canvas y ajustar el tamaño a la imagen original
          const canvas = document.createElement('canvas');
          const ctx = canvas.getContext('2d');
          canvas.width = img.width;
          canvas.height = img.height;
  
          // Dibujar la imagen en el canvas
          ctx.drawImage(img, 0, 0);
  
          // Convertir la imagen en el canvas a WebP
          canvas.toBlob((blob) => {
            if (blob) {
              const webpFile = new File([blob], file.name.replace(/\.\w+$/, '.webp'), {
                type: 'image/webp',
                lastModified: Date.now()
              });
              resolve(webpFile);  // Retorna la imagen convertida a WebP como File
            } else {
              reject(new Error('Error converting image to WebP.'));
            }
          }, 'image/webp', 0.8);  // Calidad de compresión entre 0 y 1 (0.8 es un buen equilibrio)
        };
  
        img.onerror = reject;
      };
  
      reader.onerror = reject;
      reader.readAsDataURL(file);  // Leer la imagen como Data URL
    });
  };