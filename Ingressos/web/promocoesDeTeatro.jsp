<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#cidade").autocomplete({
                    select: function (event, ui) {
                        alert("Selecionado: " + ui.item.value);
                    },
                    source: "buscaPorNome",
                    minLength: 2
                });
            });
        </script>
        <title>Promoções</title>
    </head>
    <div class="ui-widget">
        <label for="teatro">Nome</label>
        <input id="cnpj" name="teatro" placeholder="Nome do teatro" on>
    </div>
    <br/>
    <a href="index.jsp">Voltar</a>
</body>
</html>