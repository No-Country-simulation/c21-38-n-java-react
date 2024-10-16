import { useState } from 'react';

export const useFormulario = () => {
    const [isFormActive, setIsFormActive] = useState(false);
    const [isAdoptante, setIsAdoptante] = useState(true);

    const toggleActiveForm = () => setIsFormActive(true);
    const toggleIsAdoptante = () => setIsAdoptante(true);
    const toggleRefugio = () => setIsAdoptante(false);

    return {
        isFormActive,
        isAdoptante,
        toggleActiveForm,
        toggleIsAdoptante,
        toggleRefugio
    };
};
