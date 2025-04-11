const webDomain = import.meta.env.VITE_APP_COOKIES_DOMAIN || location.hostname;

class CookiesUtil {
    set({key, value, domain = webDomain, path = "/", expireDays = 1}) {
        let cookie = `${key}=${encodeURIComponent(value)};`;
        cookie += `domain=${domain};`;
        cookie += `path=${path};`;

        const expireDate = new Date();
        expireDate.setDate(expireDate.getDate() + expireDays);
        cookie += `expires=${expireDate.toUTCString()};`;

        document.cookie = cookie;
    }

    remove({key, value = "", domain = webDomain, path = "/", expireDays = -1}) {
        let cookie = `${key}=${encodeURIComponent(value)};`;
        cookie += `domain=${domain};`;
        cookie += `path=${path};`;

        const expireDate = new Date();
        expireDate.setDate(expireDate.getDate() + expireDays);
        cookie += `expires=${expireDate.toUTCString()};`;

        document.cookie = cookie;
    }

    get(key) {
        const name = `${key}=`;
        const ca = document.cookie.split(";");

        for (let c of ca) {
            c = c.trim();
            if (c.startsWith(name)) return decodeURIComponent(c.substring(name.length));
        }

        return "";
    }

    install(app) {
        app.config.globalProperties.$cookies = this;
    }
}

export default new CookiesUtil();
