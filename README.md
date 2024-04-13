# image-crypt-hillcipher

The program applies the Hill Cipher algorithm to the original image using the transformation matrix. This program generates transformation matrix, which will be used for encrypting the image. This matrix is randomly generated and invertible. This involves iterating through each pixel in the image, extracting its RGB values, and turn RGB values into gray level pixel and then applying the transformation matrix to encrypt gray values. By changing the transformation matrix, different encryption results can be achieved, enhancing the security of the encrypted image.
