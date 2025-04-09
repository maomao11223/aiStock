import axios from "axios";

class AxiosUtil {
    constructor() {
        // Initialize the instance as an empty object
        this.instance = null;
        this.reqConfig = {};  // Remove reactive, use plain object
    }

    init() {
        // Create an Axios instance
        this.instance = axios.create({
            baseURL: import.meta.env.VITE_APP_API_BASE_URL,
            timeout: 5000,
            withCredentials: false,
            headers: {
                "Content-Type": "application/json",
            },
        });

        // Request interceptor
        this.instance.interceptors.request.use(
            config => {
                this.reqConfig = config;

                // todo token handling here

                return this.reqConfig;
            },
            error => {
                return Promise.reject(error);
            }
        );

        // Response interceptor
        this.instance.interceptors.response.use(
            response => {
                const $res = response.data;

                // todo token expiration handling here

                return response.data;
            },
            error => {
                const originalRequest = this.reqConfig;

                // todo failure handling here

                return Promise.reject(error);
            }
        );
    }

    // Post method
    post(url, params = null, config = null) {
        return this.instance.post(url, params, config);
    }

    // Get method
    get(url, params = null, config = null) {
        return this.instance.get(url, {...config, params});
    }

    // Install method to inject into the global Vue app
    install(app, options) {
        const $appGlobal = app.config.globalProperties;
        $appGlobal.$axios = this;
        this.init();  // Initialize the Axios instance
    }
}

// Export a new instance of AxiosUtil
export default new AxiosUtil();
