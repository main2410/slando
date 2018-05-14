<footer>
    <span>Copyright: Sava, Online: ${onlineCounter.get()}, Logined: ${loginedCounter.get()}</span>
</footer>
</body>

<style>  
    footer{
        height: 40px;
            width: 100%;
            background: #9b9c9f;
            border-top: 1px solid black;

            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
    }
    .footerAbsolute{
        position: fixed;
        bottom: 0;
    }
</style>
<script >
    (function checkContent() {
       let footer = document.getElementsByTagName('footer');

        if (window.innerHeight >= document.documentElement.scrollHeight) {
            footer[0].classList.add('footerAbsolute');

        } else {
            footer[0].classList.remove('footerAbsolute');
        }

    })();
</script>
</html>