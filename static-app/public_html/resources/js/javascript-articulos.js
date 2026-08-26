var estado = true;

function myFunction() {
    document.getElementById('parrafo1')
            .innerHTML = 'Texto nuevo';    
}

function hideIndex() {
    if (estado) {
        document.getElementById('div-indice')
                .setAttribute('style','display: none');
        document.getElementById('btn-hide').innerHTML = 'Mostrar indice';
    } else {
        document.getElementById('div-indice')
                .setAttribute('style','display: block');
        document.getElementById('btn-hide').innerHTML = 'Esconder indice';
    }
    estado = !estado;
    // alert('el Inidice se oculto');
}

document.addEventListener("DOMContentLoaded", function() {
    hideIndex();
});